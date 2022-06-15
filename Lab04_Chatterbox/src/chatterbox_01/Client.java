package chatterbox_01;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	private Socket socket;
	
	public Client() {
	}

	public static void main(String[] args) throws UnknownHostException, IOException {
		Client client = new Client();
		client.connection();
	}

	public void connection() throws UnknownHostException, IOException {
		socket = new Socket("localhost", 5000);
	}
	
}
