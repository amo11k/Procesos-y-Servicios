package ejemplos;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContadorApplet extends Applet implements Runnable, ActionListener {
	private Thread hilo;
	private Long contador = (long) 0;
	private Boolean parar;
	private Font fuente;
	private Button b1, b2; // botones

	public void start() {

	}

	public void init() {
		setBackground(Color.yellow); // color de fondo
		add(b1 = new Button("Iniciar contador"));
		b1.addActionListener(this);
		add(b2 = new Button("Parar contador"));
		b2.addActionListener(this);
		fuente = new Font("Verdana", Font.BOLD, 26); // tipo letra
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		b1.setLabel("Continuar");
		if (e.getSource() == b1) {
			if (hilo != null && hilo.isAlive()) { // si el hilo corre no se hace
													// nada

			} else {
				hilo = new Thread(this); // si no corre se crea hilo
				hilo.start();
			}
		} else {
			parar = true; // lo para
		}

	}

	@Override
	public void run() {
		parar = false;
		Thread hiloActual = Thread.currentThread();
		while (hilo == hiloActual && !parar) {
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				System.out.println("Error");
			}
			repaint();
			contador++;
		}
	}

	public void paint(Graphics g) {
		g.clearRect(0, 0, 400, 400);
		g.setFont(fuente);
		g.drawString(Long.toString(contador), 80, 100);
	}

	public void stop() {
		hilo = null;
	}

	public static void main(String[] args) {

	}
}
