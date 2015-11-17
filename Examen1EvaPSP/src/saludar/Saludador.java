package saludar;

public class Saludador extends Thread {
	protected String nombre;
	Thread t;

	public Saludador(String nombre) {
		super();
		this.nombre = nombre;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(nombre + ": Hola!");
			interrupt();

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void start() {
		if (t == null) {
			t = new Thread(this, nombre);
			t.start();
		}
	}

}
