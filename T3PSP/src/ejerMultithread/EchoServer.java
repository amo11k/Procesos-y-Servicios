package ejerMultithread;
import java.io.IOException;
import java.net.ServerSocket;



public class EchoServer {
     public static void main(String[] args) {
               ServerSocket ssoc = null;
               try {
                    ssoc = new ServerSocket(4444);
               } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
               }
               while(true)
                    try {
                         new EchoServerThread(ssoc.accept()).start();
                    } catch (IOException e) {
                         // TODO Auto-generated catch block
                         e.printStackTrace();
                    }                    
               
     }
}