import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SenderServerSocket {
	final static String message =
 "This is a not so short text to test the reading capabilities of clients.";
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
			 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			 System.out.println(message);
			 System.out.println("message length: " + message.length());
			 out.write(message);
			 out.flush();
			 clientSocket.close();
			 
		 }
	 } catch (Exception e) {
		 e.printStackTrace();
	 }
 	}
}