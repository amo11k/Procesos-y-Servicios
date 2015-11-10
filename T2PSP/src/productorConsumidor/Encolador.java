package productorConsumidor;
import java.util.Random;

/**
 * Clase productor (runnable) que anyade personas a la cola
 * Tiene un enlace a la cola y un ID de encolador
 */
public class Encolador implements Runnable{
	
	private String ID;
	private Cola cola;

	/**
	 * Crea el encolador.
	 * @param ID nombre del encolador
	 * @param cola la cola (ya creada) donde se insertaran las personas
	 */
	public Encolador(String iD, Cola cola) {
		super();
		ID = iD;
		this.cola = cola;
	}
	
	/** Espera a que llegue la siguiente persona
	 * Duerme el hilo entre 0 y 10 segundos
	 */
	private void esperarPersona(){
		// Espera de un numero aleatrorio de segundos
		// Double t = Random.nextDouble();
		Double t = Math.random();
		
		int milisegundos = (int) (t * 10000);		
		try {
			Thread.sleep( milisegundos );
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}
	
	/**
	 * Muestra informacion de traza (println) para saber que va haciendo
	 * @param p la persona que se ha insertado en la cola
	 */
	private void traza ( Persona p){
		System.out.println ( "Encolador["+ ID +"]: se ha encolado a " + p.toString() );		
	}
	
	/**
	 * Inserta personas en la cola
	 */
	public void run() {
		
		Persona p; 
		while( true ){								
			p = new Persona ( "11111111A","Antonio","Abad","Albatera");
			this.cola.insertar( p );
			traza(p);
			esperarPersona();
			
			
			p = new Persona ( "22222222B","Beatriz","Bou","Bayo");
			this.cola.insertar( p );
			traza(p);
			esperarPersona();	
			
			
			p = new Persona ( "33333333C","Carlos","Catala","Cherza");
			this.cola.insertar( p );
			traza(p);
			esperarPersona();
			
			p = new Persona ( "44444444D","Ruben","Rumano","Guey");
			this.cola.insertar( p );
			traza(p);
			esperarPersona();
			
			p = new Persona ( "55555555E","Juani","Guadalajara","EA Games");
			this.cola.insertar( p );
			traza(p);
			esperarPersona();
			
			
		}
	}

}
