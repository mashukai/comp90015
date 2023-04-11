package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JOptionPane;

import Server.UI.Startserver;

public class ServerThread implements Runnable{

	Startserver startServer = new Startserver();
	
	private Socket client = null;

	public ServerThread(Socket client) {
		this.client = client;
	}
	
	public void run() {
		try{
			ServerSocket serverSocket = new_socket(Integer.parseInt(startServer.getMyPort()));
			while(true){
				Socket socket = serverSocket.accept();
				if(socket != null){
					String Ip = socket.getInetAddress().toString();
					int ans = JOptionPane.showConfirmDialog(null, Ip + " wants to connect with you, do you wish to continue?",  Ip + " wants to connect with you, do you wish to continue?", JOptionPane.YES_NO_OPTION);
					if (ans == 1){
						new Thread(new ServerThread(client)).start();
						//add one member to the userList
					}
					else{
						//this should close client connection
					}
				}
			}
		}
		catch(Exception e){
			 e.printStackTrace();
		}
	}
	public ServerSocket new_socket(int portNumber) throws IOException{
		ServerSocket server_socket = new ServerSocket(portNumber);
		return server_socket;
	}

}
