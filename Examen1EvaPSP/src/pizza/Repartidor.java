package pizza;

/**
 * Clase consumidor, es una repartidor de pizza extrae pizzas del horno y las
 * reparte
 *
 */
public class Repartidor implements Runnable {

	private String ID;
	private Horno horno;

	public Repartidor(String iD, Horno horno) {
		super();
		ID = iD;
		this.horno = horno;
	}

	/**
	 * Reparte la pizza Duerme el hilo entre 0 y 10 segundos
	 */
	private void repartirPizza() {
		// Espera de un numero aleatrorio de segundos
		Double t = Math.random();

		int milisegundos = (int) (t * 10000);
		try {
			Thread.sleep(milisegundos);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {

		while (true) {

			Pizza p;
			p = horno.extraer();
			if (p != null) {
				System.out.println("Repartidor - " + ID + ": repartiendo a " + p.toString());
				repartirPizza();
			} else {
				System.out.println("Repartidor - " + ID + ": Hay pizzas para repartir?");
				// If we handle correctly ours syncrhonized methods this output isn't gonna be printed never.
			}

		}

	}

}
