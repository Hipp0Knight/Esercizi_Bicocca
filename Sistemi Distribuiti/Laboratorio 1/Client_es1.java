import java.io.DataInputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Client_es1 {
	final static String messaggio = "prova di un server";
	public static void main(String[] args) {
		Socket socket; // my socket
		InetAddress serverAddress; // the server address
		int serverPort; // the server port
		try { // connect to the server
			serverAddress = InetAddress.getByName(args[0]);
			serverPort = Integer.parseInt(args[1]);
			socket = new Socket(serverAddress, serverPort);
			System.out.println("Connected to: " + socket.getInetAddress());
			//sino a qui, tutto ok
			//inizio parte di scrittura
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			System.out.println(messaggio);
			System.out.println("lunghezza: " + messaggio.length());
			out.write(messaggio);
			out.flush();
			//fine parte di scrittura
			System.out.println("I am done!");
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}