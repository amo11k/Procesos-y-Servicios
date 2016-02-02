package chat;

import java.io.BufferedReader;
import java.io.IOException;

public class ChatClientReceptorThread extends Thread {

	protected BufferedReader _receptorSocket; //
	protected boolean _activo;

	public ChatClientReceptorThread(BufferedReader receptorSocket) {
		_receptorSocket = receptorSocket;
		_activo = true;
	}

	public ChatClientReceptorThread(String hostName, int portNumber) {
		
	}

	public void run() {

		while (_activo) {
			try {
				_receptorSocket.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) throws IOException {

		String hostName = "localhost"; // Valor por defecto
		int portNumber = PuertoConst.PUERTO; // Valor por defecto

		if (args.length > 2) {
			System.err.println("Usage: java EchoClient [host name] [port number]");
			System.exit(1);
		}

		if (args.length == 2) {
			hostName = args[0];
			portNumber = Integer.parseInt(args[1]);
		} else if (args.length == 1) {
			hostName = args[0];
		}

		ChatClientReceptorThread chatClient = new ChatClientReceptorThread(hostName, portNumber);

		String mensaje;
		do {
			mensaje = System.console().readLine();
			chatClient.enviarMensaje(mensaje);
		} while (!mensaje.trim().equals("quit"));

	}

	private void enviarMensaje(String mensaje) {
		// TODO Auto-generated method stub

	}
}
