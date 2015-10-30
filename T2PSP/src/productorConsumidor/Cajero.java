package productorConsumidor;

/**
 * Clase consumidor, es una caja donde atender a las personas 
 *
 */
public class Cajero implements Runnable {

	private String ID;
	private Cola cola;


	public Cajero(String iD, Cola cola) {
		super();
		ID = iD;
		this.cola = cola;
	}
	
	
	/** Atiende a la persona persona
	 * Duerme el hilo entre 0 y 10 segundos
	 */
	private void atenderPersona(){
		// Espera de un numero aleatrorio de segundos		
		Double t = Math.random();
		
		int milisegundos = (int) (t * 10000);		
		try {
			Thread.sleep( milisegundos );
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void run() {

		try {

			while (true) {

				Persona p;
				if (!cola.estaVacia()) {
					p = cola.extraer();
					System.out.println( "Cajero - " + ID + ": Atendiendo a " + p.toString() );
					atenderPersona();
				} else{
					System.out.println("Cajero - " + ID + ": La cola esta vacia" );
				}

			}
		} catch (Exception e) {
			
			System.out.println("EXCEPCION. Caja- " + ID
					+ ". Excepcion atendiendo a las personas ¿Cola vacia?"
					+ e.getMessage());
			e.printStackTrace();
		}

	}

}
