package juego;

import java.awt.Color;

public class Movil implements IMovil{
	
	private String nombre;
	private int x;
	private int y;
	private int ancho;
	private int largo;
	private Color color;
	private Thread thread;
	
	public Movil (int x, int y, 	int ancho, 	int largo, Color color){
		this.x 		= x;
		this.y 		= y;
		this.ancho 	= ancho;
		this.largo 	= largo;
		this.color 	= color;		
	}
	
	private void mover(){
		x += 10;
		y += 10;
	}

	@Override
	public void run() {


		try {
			while (true) {
				mover();
								
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@Override
	public String toString() {
		return "Movil [nombre=" + nombre + ", x=" + x + ", y=" + y + ", ancho="
				+ ancho + ", largo=" + largo + "]";
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public int getAncho() {
		return ancho;
	}

	@Override
	public int getLargo() {
		return largo;
	}

	@Override
	public void setNombre( String nombre) {
		this.nombre = nombre;
	}

	@Override
	public void setX(int x) {
		this.x = x;		
	}

	@Override
	public void setY(int y) {
		this.y = y;
	}

	@Override
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	@Override
	public void setLargo(int largo) {
		this.largo = largo;
	}

	@Override
	public Color getColor() {
		return this.color;		
	}

	@Override
	public void setColor(Color color) {
		this.color = color;				
	}

	@Override
	public void activar() {
		this.thread = new Thread( this );
		this.thread.start();		
	}

	@Override
	public Thread getThread() {
		return this.thread;			
	}
	

}
