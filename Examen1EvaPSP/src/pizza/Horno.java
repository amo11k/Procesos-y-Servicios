package pizza;

import java.util.ArrayList;;

public class Horno {
	
	private ArrayList<Pizza>horno;
	
	/**
	 * El horno es instantaneo, cuando una pizza se mete ya esta concinada!!!
	 */
	public Horno() {
		super();
		this.horno = new ArrayList<Pizza> ();
	}
	
	/**
	 * 
	 * @return Saca una pizza del horno ya hecha
	 */
	public synchronized Pizza extraer(){
		if (horno.isEmpty()){			
			try {
				wait(); //Thats make sure that Pizza's array is not empty. If it is empty, we will stop the thread.
				return null;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println ( " Sacando pizza del horno..." );
		Pizza p = horno.get( 0 );
		horno.remove( p );
		return 	p;	
	}
	
	/** Pone la pizza en el horno
	 */
	public synchronized void cocinar( Pizza pizza){
		System.out.println ( " Cocinando pizza del horno..." );
		this.horno.add( pizza );
		notifyAll(); //Notify to the delivers that a pizza was cooked. The can use extraer() now.
	}
	
			
	/**
	 * Demostracion y prueba del horno
	 */
	public static void main(String[] args) {
		Pizza p1 = new Pizza ( "Peperoni","Familiar","Peperoni, tomate, aceituna","20%");
		Pizza p2 = new Pizza ( "Barbacoa","Mediana","Carne ternera, tomate, salsa barbacoa","SIN");
		Pizza p3 = new Pizza ( "4 Estaciones","Familiar","Alachofa, tomate, pimiento","2x1");
		
		
		Horno c = new Horno();
		c.cocinar( p1 );
		System.out.println ( c.toString() );
		c.cocinar( p2 );
		System.out.println ( c.toString() );
		c.cocinar( p3 );
		System.out.println ( c.toString() );
		
		try {
			Pizza pp1 = c.extraer();
			System.out.println( "Hemos sacado " + pp1.toString() );
			System.out.println( "El horno esta cocinando" );
			System.out.println ( c.toString() );
			
			System.out.println( "El horno esta cocinando" );
			System.out.println ( c.toString() );
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
		
	

	}

	@Override
	public String toString() {
		String texto = "Cola: ";
		for (Pizza p : horno) {
			texto += "\n\t" + p.toString();
		}
						
		return texto;
	} 

	 
	
	
	

}
