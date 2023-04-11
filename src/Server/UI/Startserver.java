package Server.UI;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.*;

import Server.ServerThread;

//import Proj1.server.ServerThread;

public class Startserver implements ActionListener{
    JFrame startFrame = new JFrame("Mini-Canvas  Start Server");
    private JTextField portNumber;
    private String myPort;

    
    public void startServer(){
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        int windowWidth = 512;
        int windowHeight = 375;
        
        JPanel icon = new JPanel();
        JPanel text = new JPanel();
        JLabel background = new JLabel();
        JLabel port = new JLabel("   Your port number:");
        portNumber = new JTextField(15);
        JButton start = new JButton(" Start ");
        JButton exit = new JButton("     Exit    ");
        
        start.addActionListener(this);
        start.setActionCommand("start");
		exit.addActionListener(this);
		exit.setActionCommand("exit");
        
        
        ImageIcon image = new ImageIcon(getClass().getResource("/icon/Loginbackground.jpg"));
        background.setIcon(image);
        icon.add(background);
        
        JPanel inputPort = new JPanel();
        inputPort.add(port);
        inputPort.add(portNumber);
        
        JPanel buttons = new JPanel();
        JPanel bbuttons = new JPanel();
        buttons.add(bbuttons, BorderLayout.CENTER);
        bbuttons.add(start);
        bbuttons.add(exit);
        
        text.setLayout( new BorderLayout() );
        text.add(inputPort,BorderLayout.NORTH);
        text.add(buttons,BorderLayout.CENTER);
        
        startFrame.setBounds((width - windowWidth) / 2,
                (height - windowHeight) / 2, windowWidth, windowHeight);
        startFrame.setVisible(true);
        startFrame.setLayout( new BorderLayout() );
        startFrame.add(icon, BorderLayout.NORTH);
        startFrame.add(text, BorderLayout.CENTER);
        startFrame.setResizable(false);
        startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }   
    
    public void actionPerformed(ActionEvent e) {  
        if(e.getActionCommand().equals("start")){  
			@SuppressWarnings("unused")
			ServerThread server_thread = new ServerThread(null);
			setMyPort(portNumber.getText());
			server_thread.run();
			// need to make sure the server starts before the implementation of white board
	        WhiteBoardServer whiteBoard = new WhiteBoardServer("Mini-Canvas Server");
	        startFrame.dispose();

        	
        }  
        if(e.getActionCommand().equals("exit")){  
            System.exit(0);  
        }  
    }

	public String getMyPort() {
		return myPort;
	}

	public void setMyPort(String myPort) {
		this.myPort = myPort;
	}
}

