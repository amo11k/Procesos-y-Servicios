package chat_Ruben;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ConexionCliente {
	
	public String 			_fechaUltimoMensaje;	
	public Socket 			_clientSocket;	
	public PrintWriter 		_enviadorSocket;
	public BufferedReader 	_receptorSocket;
	
	
	public ConexionCliente( Socket clientSocket ) throws IOException {
		super();		
		_clientSocket = clientSocket;
		_enviadorSocket = new PrintWriter( _clientSocket.getOutputStream(), true);
		
		_receptorSocket = new BufferedReader( new InputStreamReader( _clientSocket.getInputStream()) );			
	}
	
	public void close () throws IOException{
		_enviadorSocket.close();
		_receptorSocket.close();
		_clientSocket.close();			
	}
}
