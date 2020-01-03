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

public class ServerTrue {

    static String messageIn;
    static String messageOut;
    static Scanner keyboradInput = new Scanner(System.in);
    static ServerSocket server;
    static Socket connection;
    static ObjectOutputStream output;
    static ObjectInputStream input;

    public static void main(String[] args) {
        try {
            messageOut = "";
            server = new ServerSocket(12345, 100);
            while (!messageOut.equals("out")) {
                System.out.println("Waiting for the client to connect...");
                connection = server.accept();
                System.out.println("Client connected!");
                messageIn = "";

                output = new ObjectOutputStream(connection.getOutputStream());
                output.flush();
                input = new ObjectInputStream(connection.getInputStream());

                while (!messageIn.equals("out") && !messageOut.equals("out")) {

                    messageIn = "";

                    while (!messageIn.equals("out") && !messageIn.equals("over")) {

                        messageIn = (String) input.readObject();
                        System.out.println("Client says: " + messageIn);

                    }

                    if (!messageIn.equals("out")) {
                        messageOut = "";
                        while (!messageOut.equals("over") && !messageOut.equals("out")) {

                            System.out.println("Response: ");
                            keyboradInput = new Scanner(System.in);
                            messageOut = keyboradInput.nextLine();
                            output.writeObject(messageOut);
                            output.flush();
                        }
                    }
                }
            }
        } catch (SocketException s) {
            System.out.println(s.toString());
        } catch (IOException e) {
            System.out.println(e.toString());
        } catch (ClassNotFoundException cntf) {
            System.out.println(cntf.toString());
        }

    }

}
