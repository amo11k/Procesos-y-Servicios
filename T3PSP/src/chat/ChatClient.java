package chat;
/*
 * Copyright (c) 1995, 2013, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */ 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient {
	
	protected String 			_hostName;
	protected int 				_portNumber;
	protected Socket 			_echoSocket;
	protected PrintWriter  	_enviadorSocket; //
	protected BufferedReader 	_receptorSocket; //
	
	
	public ChatClient ( String hostName, int portNumber) throws UnknownHostException, IOException{
		_hostName = hostName;
		_portNumber = portNumber;
		inicializar();
		
	}
	
	
	public void inicializar () throws UnknownHostException, IOException{
		
		_echoSocket = new Socket(_hostName, _portNumber);		
		_enviadorSocket = new PrintWriter( _echoSocket.getOutputStream(), true);        		
        _receptorSocket = new BufferedReader( new InputStreamReader( _echoSocket.getInputStream() ));        	
	}
            
	
	
	public void enviarMensaje (String mensaje){
		_enviadorSocket.println( mensaje );
	}
	
	
	
    public static void main(String[] args) throws IOException {

        
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
        
        ChatClient chatClient = new ChatClient( hostName, portNumber);
                        	
    	String mensaje;
    	do{        	        
    		mensaje = System.console().readLine();
    		chatClient.enviarMensaje( mensaje );        	        	
    	} while ( !mensaje.trim().equals( "quit" ));
                
         
    }
}
