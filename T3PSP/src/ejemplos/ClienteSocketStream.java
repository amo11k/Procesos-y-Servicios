package ejemplos;

import java.io.*;
import java.net.*;

public class ClienteSocketStream {
	public static void main(String[] args) {
		try {
			Socket clientSocket = new Socket();
			InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
			clientSocket.connect(addr);
			InputStream is = clientSocket.getInputStream();
			OutputStream os = clientSocket.getOutputStream();
			String mensaje = "mensaje desde el cliente";
			os.write(mensaje.getBytes());
			clientSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
