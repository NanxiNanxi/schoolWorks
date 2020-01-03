import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.*;
import java.nio.file.attribute.DosFileAttributes;
public class ChatServer 
{
    public static void main(String[] args) 
    {
        try
        {
             ServerSocket ss = new ServerSocket(8888);
             while(true)
             {
                 Socket s = ss.accept();
                 System.out.println("Client connected!");
                 DataInputStream dis = new DataInputStream(s.getInputStream());
                 String ts = dis.readUTF();
                 System.out.println(ts);
                 dis.close();
             }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        
    }
    
}
