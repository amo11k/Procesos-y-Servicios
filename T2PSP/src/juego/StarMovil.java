package juego;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

public class StarMovil implements Runnable, IMovil {

	private Image star;
	private int x, y;
	private final int DELAY = 50;
	private Thread thread;

	public StarMovil(int x, int y, Image image) {

		this.x = x;
		this.y = 10;
		this.star = image;
	}

	public Image getImage() {
		return star;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void mover() {

		x += 10;
		y += 10;

		if (y > 240) {
			y = -45;
			x = -45;
		}

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
	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getAncho() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getLargo() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Thread getThread() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setNombre(String nombre) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setX(int x) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setY(int y) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setAncho(int ancho) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLargo(int largo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setColor(Color color) {
		// TODO Auto-generated method stub

	}

	@Override
	public void activar() {
		this.thread = new Thread(this);
		this.thread.start();

	}
}
