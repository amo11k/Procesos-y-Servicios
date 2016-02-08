package chat_Ruben;


import java.io.*;



public class ChatClientReceptorThread extends Thread{
		
	protected BufferedReader 	_receptorSocket; //
	protected PrintStream  	_comunicacionDeRecepcionSocket; //
	
	
	
	public ChatClientReceptorThread ( BufferedReader receptorSocket ){				
		this( receptorSocket, System.out );		
	}
	
	public ChatClientReceptorThread ( BufferedReader receptorSocket, PrintStream envioDeRecepcionSocket ){
		_receptorSocket = receptorSocket;	
		_comunicacionDeRecepcionSocket = envioDeRecepcionSocket;
	}
		
			            	
	public void run (){
		// recibir mensajes para el cliente
		try {
			while (!interrupted()) {

				String mensajeRecibido = _receptorSocket.readLine();
				if (mensajeRecibido == null) {
					// cierre del socket
					System.err.println("[ChatClientReceptorThread]-ERROR Socket remoto cerrado");
					System.exit(-1);
				}
				_comunicacionDeRecepcionSocket.println("RECIBIDO<<" + mensajeRecibido); // pasamos el mensaje a quien lo tiene que procesar
			}// while
		} catch (IOException e) {
			if (!interrupted()) {
				System.err.println("[ChatClient]-ERROR recibiendoMensajes	 "
						+ e.getMessage());
				e.printStackTrace();
			}
		}
						
	
	}
		
}
