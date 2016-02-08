package chat_Ruben;


import java.io.*;
import java.net.InetAddress;
import java.net.Socket;



public class ChatServerClientThread extends Thread{
		
	protected Socket 			_clientSocket;	
	protected PrintWriter 		_enviadorSocket;
	protected BufferedReader 	_receptorSocket;
	protected IPropagadorMensajesClienteChat _propagadorMensajes;
	protected INotificadorIncidenciaClienteChat _notificadorIncidencias;
	
	public ChatServerClientThread ( Socket clientSocket, final INotificadorIncidenciaClienteChat notificadorIncidencias, final IPropagadorMensajesClienteChat propagadorMensajes ) throws IOException{
		
		_clientSocket = clientSocket;
		_enviadorSocket = new PrintWriter( _clientSocket.getOutputStream(), true);		
		_receptorSocket = new BufferedReader( new InputStreamReader( _clientSocket.getInputStream()) );
		_propagadorMensajes = propagadorMensajes;
		_notificadorIncidencias = notificadorIncidencias;
		
	}
	
	public String getID( ){
		return _clientSocket.getInetAddress() + " - " + _clientSocket.getPort();
	}
	
	public void enviarMensaje ( String mensaje ){
		_enviadorSocket.println( mensaje );
	}
			
	public void close () throws IOException{
		_enviadorSocket.close();
		_receptorSocket.close();
		_clientSocket.close();
		_notificadorIncidencias.notificarMuerte( this ); // sacar de la lista de clientes
	}
			            	
	public void run (){
		
		try {
			String mensajeDelCliente;
			while (!interrupted()){ // nadie ha parado el hilo
				mensajeDelCliente = _receptorSocket.readLine();// recepcion mensaje del cliente
				if ( mensajeDelCliente == null ){
					// socket cerrado
					break;
				}
			 
				// traza
				System.out.println("[ChatServer]-Recibido:[" + this.getID() + "]" + mensajeDelCliente);
				// propagar mensaje
				_propagadorMensajes.propagarMensaje( this.getID(), mensajeDelCliente );

			}// while
		} catch (IOException e) {
			System.err.println("[ChatServer]-ERROR recibiendo/enviado mensaje" + e.getMessage() );
			e.printStackTrace();
		} finally {
			try {
				close();
			} catch (IOException e) {
						System.err.println("[ChatServer]-ERROR cerrando conexion" + e.getMessage());
						e.printStackTrace();
			}
		}// finally
							
	}
		
}
