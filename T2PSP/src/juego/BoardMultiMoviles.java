package juego;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BoardMultiMoviles extends JPanel implements Runnable {

	// http://zetcode.com/gfx/java2d/introduction/

	private Thread animator;
	private final int DELAY = 50;
	public Thread t_estrella;
	public StarMovil estrella, estrella2;
	public ArrayList<IMovil> moviles;

	public BoardMultiMoviles() {
		// Crear moviles y anyadir
		moviles = new ArrayList<IMovil>();
		this.crearMoviles();

		// ------------
		setBackground(Color.BLACK);
		setDoubleBuffered(true);
	}

	public void crearMoviles() {

		Movil m = new Movil(10, 10, 10, 10, Color.BLUE);
		MovilRapido p = new MovilRapido(10, 10, 10, 10, Color.RED);
		MovilLento l = new MovilLento(10, 10, 10, 10, Color.MAGENTA);

		moviles.add(m);
		moviles.add(p);
		moviles.add(l);
		m.activar();
		p.activar();
		l.activar();

		ImageIcon ii = new ImageIcon(this.getClass().getResource("star.png"));
		estrella = new StarMovil(10, 10, ii.getImage());
		estrella.activar();
		moviles.add(estrella);
		
		estrella2 = new StarMovil(240, 240, ii.getImage());
		estrella2.activar();
		moviles.add(estrella2);

		// estrella.activar();

		/*
		 * for (int i = 0; i < moviles_num; i++) { Movil m = new Movil(20, i *
		 * 80, 10, 10, Color.BLUE); moviles.add(m); m.activar(); // (new Thread(
		 * m )).start(); }
		 */

	}

	public void addNotify() {
		super.addNotify();
		animator = new Thread(this);
		animator.start();
	}

	public void mostrar_estrella(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		// Estrella
		g2d.drawImage(estrella.getImage(), estrella.getX(), estrella.getY(), this);
		Toolkit.getDefaultToolkit().sync();
		
		//EStrella2
		g2d.drawImage(estrella2.getImage(), estrella2.getX(), estrella2.getY(), this);
		Toolkit.getDefaultToolkit().sync();
	}

	public void paint(Graphics g) {
		super.paint(g);

		Graphics2D g2d = (Graphics2D) g;

		// Cuadrado
		mostrarMoviles(g);

		// estrella
		mostrar_estrella(g);

	}

	/**
	 * Muestra el mundo con todos sus moviles
	 */
	public void mostrarMoviles(Graphics g) {
		if (moviles == null) {
			return;
		}

		for (IMovil m : moviles) {
			mostrarMovil(m, g);
		}
	}

	public void mostrarEstrella(StarMovil estrella) {

	}

	/**
	 * Muestra el mundo con todos sus moviles
	 */
	private void mostrarMovil(IMovil m, Graphics g) {

		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(m.getColor());

		Rectangle2D.Double r = new Rectangle2D.Double(m.getX(), m.getY(), m.getAncho(), m.getLargo());
		g2d.fill(r);
	}

	public void run() {

		long beforeTime, timeDiff, sleep;

		beforeTime = System.currentTimeMillis();

		while (true) {

			repaint();

			timeDiff = System.currentTimeMillis() - beforeTime;
			sleep = DELAY - timeDiff;

			if (sleep < 0)
				sleep = 2;
			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				System.out.println("interrupted");
			}

			beforeTime = System.currentTimeMillis();
		}
	}

}
