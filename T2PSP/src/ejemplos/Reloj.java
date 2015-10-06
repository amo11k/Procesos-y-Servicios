package ejemplos;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Reloj extends Applet implements Runnable{
	private Thread hilo = null; // hilo
	private Font fuente; // tipo de letra
	private String horaActual = "";

	public void init() {
		fuente = new Font("Verdana", Font.BOLD, 26);
	}

	public void start() {
		if (hilo == null) {
			hilo = new Thread(this);
			hilo.start();
		}
	}

	@Override
	public void run() {
		Thread hiloActual = Thread.currentThread();
		while (hilo == hiloActual){
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			Calendar cal = Calendar.getInstance();
			horaActual = sdf.format(cal.getTime());
			repaint(); //actualizar contenido del applet
			try{
				Thread.sleep(1000);
			}catch (InterruptedException e){
				
			}
		}
		
	}
	
	public void paint(Graphics g){
		g.clearRect(1, 1, getSize().width,getSize().height );
		setBackground(Color.cyan);
		g.setFont(fuente);
		g.drawString(horaActual, 20, 50); //muestra la hora
	}
	
	public void stop(){
		hilo = null;
	}
	
public static void main(String[] args) {
		
	}
}
