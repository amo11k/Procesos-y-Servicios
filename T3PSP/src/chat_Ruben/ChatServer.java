package chat_Ruben;

import java.net.*;
import java.util.ArrayList;
import java.io.*;

public class ChatServer implements INotificadorIncidenciaClienteChat, IPropagadorMensajesClienteChat{
	
	protected int _portNumber;
	protected ServerSocket _serverSocket;
	protected ArrayList<ChatServerClientThread> _clientes;
	
	public ChatServer ( int portNumber) throws IOException{
		System.out.print("[ChatServer]-Iniciando servidor...");
		_portNumber = portNumber;		
		inicializar();
	}
	
	protected void inicializar() throws IOException{
	    _serverSocket = new ServerSocket( _portNumber );
	    _clientes = new ArrayList<ChatServerClientThread>();
	    System.out.println(" Completado");
	}
	
	
	synchronized protected void registrarClienteChat( ChatServerClientThread cliente ){
		_clientes.add( cliente );					
	}
	
	synchronized protected void eliminarClienteChat( ChatServerClientThread cliente ){
		_clientes.remove( cliente );
	}

	@Override
	public void notificarMuerte ( ChatServerClientThread  cliente ){
		eliminarClienteChat ( cliente );
	}
	
	@Override
	synchronized  public void propagarMensaje(String origenID, String mensaje) {
		for ( ChatServerClientThread cliente : _clientes ){
			if ( origenID.equals( cliente.getID() )){
				// No se propaga el mensaje al cliente de origen
				continue;
			}
			cliente.enviarMensaje( origenID + " : " + mensaje );
		}
		
	}	
	
	
	protected void run() {
		
	    boolean activo = true;
	    
	    
		while ( activo ){
			
			// Crear Conexion 
			Socket clientSocket;
			try {
				System.out.println("[ChatServer]-Esperando conexion...");
				clientSocket = _serverSocket.accept();
				System.out.println("[ChatServer]-Conexion recibida.");
				ChatServerClientThread cliente = new ChatServerClientThread( clientSocket, this, this ); // Creamos y lanzamos el thread que atiende al cliente
				cliente.start();
				registrarClienteChat ( cliente );	
				
				
								
			} catch (IOException e) {
				System.err.println( "[ChatServer]-ERROR aceptando conexion" + e.getMessage());
				e.printStackTrace();
				continue;
			}

		}//while
		
        
	}

	
	
	
	
	
    public static void main(String[] args) throws IOException {
    	
        // Comprobar e inicializar parametros    	
    	int portNumber = PuertoConst.PUERTO; // Valor por defecto
    	
    	if (args.length > 1) {
            System.err.println( "Usage: java ChatServer <port number>" );
            System.exit(1);
        }
        
        if (args.length == 1) {        	
            portNumber = Integer.parseInt(args[0]);            
        }
        
        // Arrancar servidor
        try {
        	new ChatServer( portNumber ).run();            
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }

}
