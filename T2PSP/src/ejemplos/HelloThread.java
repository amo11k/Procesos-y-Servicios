package ejemplos;

class HelloThread implements Runnable {
	Thread t;

	HelloThread() {
		t = new Thread(this, "Nuevo Thread");
		System.out.println("Creado hilo: " + t);
		t.start();
	}

	@Override
	public void run() {
		System.out.println("Hola desde el hilo creado");
		System.out.println("Hilo finalizado");

	}
}