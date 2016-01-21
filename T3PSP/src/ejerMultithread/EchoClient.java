package ejerMultithread;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class EchoClient {
     public static void main (String [] args){
          try {
               Socket soc = new Socket("localhost",4444);
               PrintWriter out = new PrintWriter(soc.getOutputStream(),true);
               BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
               BufferedReader stdIn= new BufferedReader(new InputStreamReader(System.in));
               String rline;
               while((rline=stdIn.readLine())!=null){
                    out.println(rline);
                    //System.out.println("written: "+rline);
                    /*String fromServer = in.readLine();
                    if(fromServer.equals("exit")){
                         System.out.println("Server is going down....");
                         System.out.println("fuck");
                         break;
                    }                    
                    else{*/
                    System.out.println("echo: "+in.readLine());
                    //}
               }
               in.close();
               out.close();
               stdIn.close();
               soc.close();
          } catch (UnknownHostException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
               System.exit(1);
          } catch (IOException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
               System.exit(2);
          }
     }
}