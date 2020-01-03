import java.awt.*;
import java.awt.event.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChatClient02 extends Frame
{
    Socket s = null;
    TextField tfTxt = new TextField();
    TextArea taContent = new TextArea();
    
    public static void main(String[] args) 
    {
        new ChatClient02().lauchFrame();
    }
    public void lauchFrame()
    {
        setLocation(400,300);
        this.setSize(500,500);
        add(tfTxt,BorderLayout.SOUTH);
        add(taContent,BorderLayout.NORTH);
        pack();
       
        this.addWindowListener(new WindowAdapter() {
//            @Override
        
        public void windowClosing(WindowEvent arg0){
                System.exit(0);
            }});
        tfTxt.addActionListener(new textFieldListener());
        setVisible(true);
        connect();
    }
    private class textFieldListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String ts = tfTxt.getText().trim();
            taContent.setText(ts);
            tfTxt.setText("");
            try 
            {
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                dos.writeUTF(ts);
                dos.flush();
                dos.close();
            } 
            catch (IOException ex) 
            {
                Logger.getLogger(ChatClient02.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void connect()
    {
        try
        {
            s = new Socket("Your server's Ip", 8888);
            System.out.println("connected!");
        }
        catch(UnknownHostException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
            
    }
    }
