package pizza;

/**
 * Clase productor (runnable) que anyade personas a la cola
 * Tiene un enlace a la cola y un ID de encolador
 */
public class PizzaWeb implements Runnable{
	
	private String ID;
	private Horno horno;

	/**
	 * Esta es la web que recibe los pedidos de los clientes y envia la pizza al horno
	 * Se pueden instanciar varias webs porque hay varios servidores que recogen los pedidos .es .com...
	 * @param ID nombre del encolador
	 * @param cola la cola (ya creada) donde se insertaran las personas
	 */
	public PizzaWeb(String iD, Horno horno) {
		super();
		ID = iD;
		this.horno = horno;
	}
	
	/** Espera a que llegue el siguiente pedido
	 * Duerme el hilo entre 0 y 10 segundos para simularlo
	 */
	private void esperarPedido(){
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
	 * @param p la pizza (pedido) que se ha insertado en la cola
	 */
	private void traza ( Pizza p){
		System.out.println ( "PizzaWeb["+ ID +"]: se ha pedido:  " + p.toString() );		
	}
	
	/**
	 * Inserta las pizzas en el horno
	 */
	public void run() {
		
		Pizza p; 
		while( true ){								
			
			p = new Pizza ( "Peperoni","Familiar","Peperoni, tomate, aceituna","20%");									
			this.horno.cocinar( p );
			traza(p);
			esperarPedido();
			
			p = new Pizza ( "4 quesos","Pequenya","Semi, mozzarella, feta","SIN");			
			this.horno.cocinar( p );
			traza(p);
			esperarPedido();
			
			p = new Pizza ( "Barbacoa","Mediana","Carne ternera, tomate, salsa barbacoa","SIN");			
			this.horno.cocinar( p );
			traza(p);
			esperarPedido();						
			
			p = new Pizza ( "4 Estaciones","Familiar","Alachofa, tomate, pimiento","2x1");
			this.horno.cocinar( p );
			traza(p);
			esperarPedido();
		}
	}

}
