/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg233final2.pkg0;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Responder implements Runnable {

    private Socket requestHandler;
    private Scanner requestReader;
    private DataOutputStream pageWriter;
    private String HTTPMessage;
    private String requestedURL;
    private String requestedFile;

    public Responder() {

    }

    public Responder(Socket requestHandler) {
        this.requestHandler = requestHandler;
    }

    public void run() {
        System.out.println("Waiting For IE to request a page:");
        System.out.println("Page Requested: Request Header:");

        try {
            requestReader = new Scanner(new InputStreamReader(requestHandler.getInputStream()));
            pageWriter = new DataOutputStream(requestHandler.getOutputStream());
            int lineCount = 0;
            do {
                lineCount++;
                //just in case when click the stop button there will be a NullPointerException
                try {
                    HTTPMessage = requestReader.nextLine();
                } catch (Exception e) {
                    System.out.println(e.toString());
                }

              
                if (lineCount == 1) {
                    
                    requestedURL = HTTPMessage.substring(5, HTTPMessage.indexOf("HTTP/1.1") - 1);
                    if (requestedURL.length() == 0) {
                        requestedURL = "default.htm";
                    } else if (requestedURL.equals("subdir") || requestedURL.equals("subdir/")) {
                        requestedURL = "default.htm";
                    } else if (!requestedURL.contains(".htm")) {
                        //if there's not contains .htm, then add the default page adress to the url.
                        requestedURL += "default.htm";
                    }

                    requestedFile = "WebRoot\\" + requestedURL;
                    printOutLog(requestedFile);

                    requestedFile = requestedFile.trim();
                    //if the requests from service page has been submitted, then resultpage contains "doService",then connect to database and print out the result
                    if (requestedFile.indexOf("doSERVICE") > -1) {
                        Service service = new SQLSelectService(pageWriter, requestedFile);
                        service.doWork();
                    } else {
                        //if it's not the result page, then show the pages that i have
                        try {
                            Scanner pageReader = new Scanner(new File(requestedFile));
                            while (pageReader.hasNext()) {
                                String s = pageReader.nextLine();
                                pageWriter.writeBytes(s);
                            }
                            GuiServer.closeAll(pageReader, pageWriter, requestHandler);

                        } catch (Exception e) {
                            printOutLog(e.toString());
                            //if that page does not exit, then catch the exception and show 404error page
                            requestedFile = "WebRoot\\Util\\error404.htm";
                            requestedFile = requestedFile.trim();
                            Scanner pageReader = new Scanner(new File(requestedFile));
                            DataOutputStream pageWriter = new DataOutputStream(requestHandler.getOutputStream());
                            while (pageReader.hasNext()) {
                                String s = pageReader.nextLine();
                                pageWriter.writeBytes(s);
                            }
                            GuiServer.closeAll(pageReader, pageWriter, requestHandler);
                        }
                    }
                }

                System.out.println(HTTPMessage);
                printOutLog(HTTPMessage);

            } while (HTTPMessage.length() != 0);
        } catch (IOException e) {
            System.out.println(e.toString());
        }

    }

    public void printOutLog(String outputRequest) {
        try {
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            GuiServer.getRequestOutput().append("\r\n" + timeStamp + "\n" + outputRequest + "\n");
            GuiServer.requestOutput.setCaretPosition(GuiServer.requestOutput.getText().length());
            FileWriter fw = new FileWriter("WebRoot\\requestLog.txt", true);
            BufferedWriter br = new BufferedWriter(fw);
            br.write("\r\n" + timeStamp + "\n" + outputRequest + "\n");
            GuiServer.closeAll(br);

        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

}
