package ejerMultithread;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class EchoServerThread extends Thread{
     private Socket s;
     
     public EchoServerThread(Socket socket){
          super("EchoServerThread");
          this.s=socket;
     }
     
     public void run(){
          try {
               PrintWriter out = new PrintWriter(s.getOutputStream(),true);
               BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
               String rline;
               while((rline=in.readLine())!=null){
                    /*if(rline.equalsIgnoreCase("exit")) {
                         out.println("exit");
                         break;
                    }*/
                    
                    out.println(rline);
}
               in.close();
               out.close();
               s.close();
          } catch (IOException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
          }          
     }
}