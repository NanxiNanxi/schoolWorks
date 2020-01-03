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
public class ServerModified {
    static String messageIn;
    static String messageOut;
    static Scanner keyboradInput;
    static ServerSocket server;
    static Socket connection;
    static ObjectOutputStream output;
    static ObjectInputStream input;
    
    public static void main(String[] args) {
        try {
            server = new ServerSocket(12345,100);
            System.out.println("Waiting for the client to connect...");
            connection = server.accept();
            System.out.println("Client connected!");
            
           String test = "";
           keyboradInput = new Scanner(System.in);
            while(!test.equals("out")){
            output = new ObjectOutputStream(connection.getOutputStream());
            output.flush();
            input = new ObjectInputStream(connection.getInputStream());
            messageIn = (String)input.readObject();
            
            System.out.println("Client says: " + messageIn);
//            System.out.println("Response: ");
             String out = "";
          while(!out.equals("over") && !out.equals("out")){
            System.out.println("Please type your Response message: ");
            
//            keyboradInput.nextLine();
            out = keyboradInput.nextLine();
            messageOut += out+ "\n";
            }
          test = out;
//            keyboradInput = new Scanner(System.in);
//            messageOut = keyboradInput.nextLine();
            output.writeObject(messageOut);
            output.flush();
             
            }
           
            
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        catch(ClassNotFoundException cntf){
            System.out.println(cntf.toString());
        }
        
    }
    
}
