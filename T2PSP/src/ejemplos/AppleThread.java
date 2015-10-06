package ejemplos;

import java.awt.Graphics;

public class AppleThread implements Runnable {
	private Thread hilo = null;

	public void init() {
	}

	public void start() {
		if (hilo == null) {
			// crea el hilo
			hilo = new Thread(this);
			hilo.start();// lanza hilo
		}
	}
	@Override
	public void run() {
		Thread hiloActual = Thread.currentThread();
		while (hilo == hiloActual) {
			// tarea repetitiva
		}
	}

	public void stop() {
		hilo = null;
	}
	
	public void paint(Graphics g){
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
