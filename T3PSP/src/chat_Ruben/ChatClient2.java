package chat_Ruben;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatClient2 {
	
	protected String 			_hostName;
	protected int 				_portNumber;
	protected Socket 			_socket;
	protected PrintWriter  	_enviadorSocket; //
	protected BufferedReader 	_receptorSocket; //
	protected ChatClientReceptorThread _receptorThread;
	
		
	public ChatClient2 ( String hostName, int portNumber) throws UnknownHostException, IOException{
		System.out.println("[ChatClient]-Iniciando aplicacion. ");
		_hostName = hostName;
		_portNumber = portNumber;
		inicializar();
		System.out.println("[ChatClient]-Iniciacion aplicacion completada. ");
		
	}
	
	
	public void inicializar () throws UnknownHostException, IOException{
		System.out.println("[ChatClient]-Iniciando comunicacion... ");
		// Conexion con el servidor
		_socket = new Socket(_hostName, _portNumber);
		// entrada/salida socket
		_enviadorSocket = new PrintWriter( _socket.getOutputStream(), true);        		
        _receptorSocket = new BufferedReader( new InputStreamReader( _socket.getInputStream() ));
        
        // Thread escuchador
        System.out.println("[ChatClient]- \t Iniciando recepcion mensajes. ");
        
        _receptorThread = new ChatClientReceptorThread( _receptorSocket );
        _receptorThread.start();
        
        
        System.out.println("[ChatClient]-Iniciacion comunicacion completada. ");
	}
            
	
	
	public void enviarMensaje (String mensaje){
		_enviadorSocket.println( mensaje );
	}
	
	public void close () throws IOException{
		System.out.println("[ChatClient]-Cerrando aplicacion.");
		
		_receptorThread.interrupt();
		_enviadorSocket.close();		
		_receptorSocket.close();
		_socket.close();
		
		System.out.println("[ChatClient]-Cierre aplicacion completado. ");
	
	}
	
	
	
    public static void main(String[] args) {

        // Comprobar e inicializar parametros
    	String hostName = "localhost"; // Valor por defecto
    	int portNumber = PuertoConst.PUERTO; // Valor por defecto
    	
        if (args.length > 2) {
            System.err.println(
                "Usage: java EchoClient [host name] [port number]");
            System.exit(1);
        }
        
        if (args.length == 2) {
        	hostName = args[0];
            portNumber = Integer.parseInt(args[1]);            
        } else if( args.length == 1 ){
        	hostName = args[0];
        }

        // Arrancar clienteChat
        ChatClient2 chatClient = null;
		try {
			chatClient = new ChatClient2( hostName, portNumber );
		} catch (UnknownHostException e) {
			System.err.println("[ChatClient]-ERROR Estableciendo conexion " + e.getMessage() );
			e.printStackTrace();
			System.exit( -1 );
		} catch ( IOException e) {
			System.err.println("[ChatClient]-ERROR Estableciendo conexion " + e.getMessage() );
			e.printStackTrace();
			System.exit( -2 );
		}
		
		try{
	    	String mensaje;
	    	Scanner scanner = new Scanner(System.in);
	    	do{
	    		System.out.print("ENVIAR  >> ");
	    		mensaje = scanner.nextLine();	    		
	    		chatClient.enviarMensaje( mensaje );
	    	} while ( !mensaje.trim().equals( "quit" ));
	    	scanner.close();
    	
		}finally {
			try {
				chatClient.close();		
			} catch (IOException e) {
					System.err.println("[ChatClient]-ERROR Estableciendo cerrando aplicacion" + e.getMessage() );
					e.printStackTrace();						
					System.exit( -3 );
			}
			
		}
                
         
    }
}
