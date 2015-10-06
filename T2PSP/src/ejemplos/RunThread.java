package ejemplos;

class RunThread {
	public static void main(String args[]) {
		new HelloThread();
		System.out.println("Hola desde el hilo principal!");
		System.out.println("Proceso acabado");
	}
}