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
public class ClientModified {
    static String messageIn;
    static String messageOut ;
    static Scanner keyboradInput;
    
    //declare object to maintain connection
    static Socket client;
    static ObjectOutputStream output;
    static ObjectInputStream input;
    public static void main(String[] args) {
        try {
            client = new Socket(InetAddress.getByName("127.0.0.1"), 12345);
            
            //1 establish IO path between client and server
            
            String out = "";
            String test = "";
            messageOut ="";
            while(!test.equals("out")){
            ObjectOutputStream output = new ObjectOutputStream(client.getOutputStream());
            output.flush();
            ObjectInputStream input = new ObjectInputStream(client.getInputStream());
                //2 wait for the out client user yupe a message
            out = "";
            while(!out.equals("over") && !out.equals("out")){
            System.out.println("Please type your message: ");
            keyboradInput = new Scanner(System.in);
            out = keyboradInput.nextLine();
            messageOut += out+ "\n";
            }
            test = out;
            //3 send the message out
            output.writeObject(messageOut);
            output.flush();
            
            //4 wait for an incoming string object
            messageIn = (String)input.readObject();
            
            //5 print it to the screen
            System.out.println("Server says: " + messageIn);
            
            }
            
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        catch(ClassNotFoundException cnfe){
            cnfe.toString();
        }
        
    }
}
