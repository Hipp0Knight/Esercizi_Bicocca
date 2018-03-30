import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_es2 {
	public static void main(String[] args) {
	 try {
		 Socket clientSocket;
		 ServerSocket listenSocket;
		 listenSocket = new ServerSocket(53535);
		 System.out.println("Running Server: " +
				 "Host= " + listenSocket.getInetAddress() +
				 " Port= " + listenSocket.getLocalPort());
		 //loop to open a connection, send the message, close the connection
		 while (true) {
			 clientSocket = listenSocket.accept();
			 //inizio parte di scrittura
			 DataInputStream in; // the source of stream of bytes
				byte[] byteReceived = new byte[1000]; // the temporary buffer
				//String messageString = ""; // the text to be displayed
				String[] messageBuffer = new String[1000];
				// the stream to read from
				in = new DataInputStream(clientSocket.getInputStream());
				System.out.println("\nReady to read from the socket");
				// The following code shows in detail how to read from a TCP socket
				boolean x = true;
				int i = 0;
				while (x) {
					int bytesRead = 0; // the number of bytes read
					bytesRead = in.read(byteReceived);
					messageBuffer[i] = new String(byteReceived, 0, bytesRead);
					if (messageBuffer[i].equalsIgnoreCase("exit"))
						x = false;
					i++;
				}
				System.out.println("messages received:");
				for(int k = 0; (k < messageBuffer.length) && (messageBuffer[k] != null); k++) {
					System.out.println(messageBuffer[k]);
				}
			 clientSocket.close();
			 System.out.println("Socket closed");
			 
		 }
	 } catch (Exception e) {
		 e.printStackTrace();
	 }
 	}
}