/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg233final2.pkg0;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.ExecutorService;
import java.io.Closeable;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.Executors;
import javax.swing.JOptionPane;

public class GuiServer extends JFrame implements Runnable {

    public static JTextArea requestOutput;
    private JButton requestStart;
    private JButton requestStop;
    private boolean switchForGUI = false;
    private ServerSocket requestListener;
    private ExecutorService resonses;
    private JScrollPane scrollBar;
    static int HTTP_PORT;
    static GuiServer guiServer;

    public static void main(String[] args) {
        guiServer = new GuiServer();
        //exit when close gui
        guiServer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static JTextArea getRequestOutput() {
        return requestOutput;
    }
    //create a getter for the flag, so that i can use to end the loop in run()

    public boolean isSwitchForGUI() {
        return switchForGUI;
    }

    public GuiServer() {

        //set title bar
        super("Web Server");

        //set diemensions
        setSize(700, 700);

        //tell it to appear
        setVisible(true);
        //determines the layout

        BorderLayout layout = new BorderLayout();
        setLayout(layout);

        //add some controls
        requestOutput = new JTextArea();
        //wrap automatically
        requestOutput.setLineWrap(true);

        scrollBar = new JScrollPane(requestOutput);
        scrollBar.setBounds(13, 10, 450, 450);
        scrollBar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        //add scroll bar for GUI
        add(scrollBar);

        requestStart = new JButton("Start");
        requestStop = new JButton("Stop");

        Panel requestInputContainer = new Panel();
        requestInputContainer.add(requestStart);
        requestInputContainer.add(requestStop);

        add(requestInputContainer, BorderLayout.SOUTH);

        try {
            String targetPort = JOptionPane.showInputDialog("Enter a port number:");
            HTTP_PORT = Integer.parseInt(targetPort);
            requestListener = new ServerSocket(HTTP_PORT);
            resonses = Executors.newFixedThreadPool(100);

        } catch (IOException e) {
            closeAll(requestListener);
            System.out.println(e.toString());
        }

        requestStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                switchForGUI = true;
                requestStart.setEnabled(false);
                if (switchForGUI) {
                    resonses.execute(guiServer);
                }

            }
        }
        );
        requestStop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                switchForGUI = false;
                requestStart.setEnabled(true);
            }
        }
        );
        setVisible(true);

    }


    public void run() {
        while (switchForGUI) {
            try {
                if (switchForGUI) {
                    Responder responder = new Responder(requestListener.accept());
                    
                    if (switchForGUI) {
                       resonses.execute(responder);
                    }
                }
                //listen to the stop button in GUI, if stop button clicked, then jump out from the loop, stop processing threads.
                switchForGUI = isSwitchForGUI();
            } catch (IOException e) {
                System.out.println(e.toString());
            }

        }

    }
//create a close function to close serveral closeable(for io stream) at the same time

public static void closeAll(Closeable... able) {
        for (Closeable c : able) {
            if (c != null) {
                try {
                    c.close();
                } catch (IOException e) {
                    System.out.println(e.toString());
                }
            }
        }
    }
}
