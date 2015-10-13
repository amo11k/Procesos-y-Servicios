package juego;

import java.awt.Color;

public class MovilRapido extends Movil{
	private String nombre;
	private int x;
	private int y;
	private int ancho;
	private int largo;
	private Color color;
	private Thread thread;
	
	public MovilRapido(int x, int y, int ancho, int largo, Color color) {
		super(x, y, ancho, largo, color);
	}
	
	private void mover(){
		this.setX(this.getX()+5);
		this.setY(this.getY()+10);
	}
	
	public void run() {


		try {
			while (true) {
				mover();
								
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
