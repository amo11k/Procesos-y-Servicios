package juego;

import java.awt.Color;

public class MovilLento extends Movil{

	public MovilLento(int x, int y, int ancho, int largo, Color color) {
		super(x, y, ancho, largo, color);
		// TODO Auto-generated constructor stub
	}
	
	private void mover(){
		this.setX(this.getX()+20);
		this.setY(this.getY()+10);
	}

	@Override
	public void run() {


		try {
			while (true) {
				mover();
								
				Thread.sleep(2500);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
