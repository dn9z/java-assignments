package chatterbox_01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private ServerSocket serverSocket;
	private Socket socket;
	
	public Server() {
			}

	public static void main(String[] args) throws IOException {
		Server server = new Server();
		server.connection();
	}
	
	public void connection() throws IOException {
		
		serverSocket = new ServerSocket(5000);
		System.out.println("Waiting for client to join");
		
		socket = serverSocket.accept();
		System.out.println("Connection established");
		
		
	}

}
