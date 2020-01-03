/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab9;

/**
 *
 * @author zhou6718
 */
import java.util.*;
import java.io.*;
import java.net.*;

public class ClientTrue {

    static String messageIn;
    static String messageOut;
    static Scanner keyboradInput = new Scanner(System.in);

    //declare object to maintain connection
    static Socket client;
    static ObjectOutputStream output;
    static ObjectInputStream input;

    public static void main(String[] args) {
        try {
            messageIn = "";
            client = new Socket(InetAddress.getByName("127.0.0.1"), 12345);

            //1 establish IO path between client and server
            messageOut = "";
            ObjectOutputStream output = new ObjectOutputStream(client.getOutputStream());
            output.flush();
            ObjectInputStream input = new ObjectInputStream(client.getInputStream());
            while (!messageOut.equals("out") && !messageIn.equals("out")) {
                messageOut = "";
                while (!messageOut.equals("out") && !messageOut.equals("over") && !messageIn.equals("out")) {
                    //2 wait for the out client user yupe a message
                    System.out.println("Please type your message: ");
                    keyboradInput = new Scanner(System.in);
                    messageOut = keyboradInput.nextLine();
                    //3 send the message out
                    output.writeObject(messageOut);
                    output.flush();
                }
                messageIn = "";
                while (!messageIn.equals("over") && !messageIn.equals("out") && !messageOut.equals("out")) {
                    //4 wait for an incoming string object
                    messageIn = (String) input.readObject();

                    //5 print it to the screen
                    System.out.println("Server says: " + messageIn);
                }

            }
            client.close();

        } catch (SocketException s) {
            System.out.println(s.toString());
        } catch (IOException e) {
            System.out.println(e.toString());
        } catch (ClassNotFoundException cnfe) {
            cnfe.toString();
        }

    }
}
