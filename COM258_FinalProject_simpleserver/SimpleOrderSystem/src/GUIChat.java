
/**
 *
 * @author zhou6718
 */
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author osborne
 */
public class GUIChat extends JFrame implements ChatIF {

    final public static int DEFAULT_PORT = 5555;
    ChatClient client;

    private JButton closeB = new JButton("Close");
    private JButton openB = new JButton("Open");
    private JButton sendB = new JButton("Send");
    private JButton quitB = new JButton("Quit");
    private JButton joinB = new JButton("Join");
    private JButton resetHostB = new JButton("Reset Host");
    private JButton resetPortB = new JButton("Reset Port");

    private JTextField portTxF = new JTextField("5555");
    private JTextField hostTxF = new JTextField("127.0.0.1");
    private JTextField messageTxF = new JTextField("");
    private JTextField roomTxF = new JTextField("");
    private JTextField accountTxF = new JTextField("");

    private JLabel portLB = new JLabel("Port: ", JLabel.LEFT);
    private JLabel hostLB = new JLabel("Host: ", JLabel.LEFT);
    private JLabel messageLB = new JLabel("Message: ", JLabel.LEFT);

    private JCheckBox isPmCB = new JCheckBox("PM to: ");

    private JTextArea messageList = new JTextArea();

    public GUIChat(String host, int port) {
        super("Simple Chat GUI");
        setSize(300, 400);

        setLayout(new BorderLayout(5, 5));
        JPanel bottom = new JPanel();
        add("Center", messageList);
        add("South", bottom);

        bottom.setLayout(new GridLayout(8, 2, 5, 5));
        bottom.add(hostLB);
        bottom.add(hostTxF);
        bottom.add(portLB);
        bottom.add(portTxF);
        bottom.add(isPmCB);
        bottom.add(accountTxF);
        bottom.add(messageLB);
        bottom.add(messageTxF);
        bottom.add(openB);
        bottom.add(sendB);
        bottom.add(joinB);
        bottom.add(roomTxF);
        bottom.add(resetHostB);
        bottom.add(resetPortB);
        bottom.add(closeB);
        bottom.add(quitB);

        openB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                open();
                display(messageTxF.getText());
            }
        });
        sendB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                send();
                display(messageTxF.getText());
                
            }
        });
        joinB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                join();
                display(messageTxF.getText());
            }
        });
        
        resetHostB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (hostTxF.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter  valid Host!", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                client.setHost(hostTxF.getText());
                display(messageTxF.getText());
            }
        });
        resetPortB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (portTxF.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter  valid Port!", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    client.setPort(Integer.parseInt(portTxF.getText()));
                    display(messageTxF.getText());
                    
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Please enter valid Port!", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }

            }
        });

        closeB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String msg = "#logoff";
                accept(msg);

            }
        });

        quitB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);

            }
        });

        setVisible(true);

        try {
            client = new ChatClient(host, port, this);
        } catch (IOException exception) {
            System.out.println("Error: Can't setup connection!"
                    + " Terminating client.");
            System.exit(1);
        }

    }

    public void display(String message) {
        messageList.insert(message + "\n", 0);
    }

    public void open() {
        String account = JOptionPane.showInputDialog("Please enter an account: ");
        account = "#login " + account;
        accept(account);
        // messageList.insert(message, 0);

    }

    public void send() {
        String message = "";
        if (isPmCB.isSelected() && accountTxF.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter an PM account!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (isPmCB.isSelected() && !accountTxF.getText().isEmpty()) {
            message = "#pm " + accountTxF.getText() + " ";
        }
        message = message + messageTxF.getText();
        accept(message);
        messageTxF.setText("");

    }

    public void join() {
        String room = roomTxF.getText();
        room = "#join " + room;
        accept(room);
    }

    public void accept(String message) {
        try {

            if (message.startsWith("#")) {
                client.handleCommand(message);
            } else {
                client.handleMessageFromClientUI(message);

            }

        } catch (Exception ex) {
            System.out.println("Unexpected error while reading from console!");
        }
    }

    public static void main(String[] args) {

        String host = "";
        int port = 0;  //The port number

        try {
            port = Integer.parseInt(args[1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            port = DEFAULT_PORT;
        }
        System.out.println("PORT:" + port);

        try {
            host = args[0];
        } catch (ArrayIndexOutOfBoundsException e) {
            host = "localhost";
        }

        GUIChat clientConsole = new GUIChat(host, port);
        clientConsole.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
