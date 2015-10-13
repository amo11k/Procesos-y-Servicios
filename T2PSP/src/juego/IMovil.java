package juego;

import java.awt.Color;

public interface IMovil extends Runnable {
	public String getNombre ();
	public int getX();
	public int getY();
	public int getAncho();
	public int getLargo();
	public Color getColor();
	public Thread getThread();
		
	public void setNombre ( String nombre );
	public void setX( int x );
	public void setY( int y );
	public void setAncho( int ancho );
	public void setLargo( int largo );
	public void setColor( Color color );
	
	public void activar();
}
