import java.io.DataInputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_es1 {
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
				String messageString = ""; // the text to be displayed
				// the stream to read from
				in = new DataInputStream(clientSocket.getInputStream());
				System.out.println("Ready to read from the socket");
				// The following code shows in detail how to read from a TCP socket
				int bytesRead = 0; // the number of bytes read
				bytesRead = in.read(byteReceived);
				messageString += new String(byteReceived, 0, bytesRead);
				System.out.println("sent: " + messageString);
			 clientSocket.close();
			 
		 }
	 } catch (Exception e) {
		 e.printStackTrace();
	 }
 	}
}