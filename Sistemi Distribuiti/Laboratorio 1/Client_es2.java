import java.io.PrintWriter;
import java.util.Scanner;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Client_es2 {
	public static void main(String[] args) {
		Scanner tast = new Scanner(System.in);
		String messaggio = "";
		Socket socket; // my socket
		InetAddress serverAddress; // the server address
		int serverPort; // the server port
		try { // connect to the server
			//serverAddress e serverPort sono HardCoded, nel caso si vogliano variabili sostituire con args
			serverAddress = InetAddress.getByName("0.0.0.0");
			serverPort = Integer.parseInt("53535");
			//fine parte HardCoded
			socket = new Socket(serverAddress, serverPort);
			System.out.println("Connected to: " + socket.getInetAddress());
			//sino a qui, tutto ok
			//inizio parte di scrittura
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			boolean x = true;
			System.out.println("write the message to send!");
			while (x) {
				messaggio = tast.nextLine();
				System.out.println("sending:" + messaggio);
				System.out.println("length: " + messaggio.length());
				if (messaggio.equalsIgnoreCase("exit"))
						x = false;
				out.write(messaggio);
				out.flush();
			}
			//fine parte di scrittura
			System.out.println("I am done!");
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}