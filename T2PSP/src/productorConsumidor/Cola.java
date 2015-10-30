package productorConsumidor;

import java.util.ArrayList;;

public class Cola {
	
	private ArrayList<Persona>cola;
	
	/**
	 * Crear un cola vacia
	 */
	public Cola() {
		super();
		this.cola = new ArrayList<Persona> ();
	}
	
	/**
	 * 
	 * @return Devuelve el primer elemento (y lo saca del arraylist)
	 * @throws Exception Excepcion si se intenta sacar e una lista vacia
	 */
	public synchronized Persona extraer() throws Exception{
		if (cola.isEmpty()){
			throw new Exception( "Cola.Extraer: La cola esta vacia");
		}
		Persona p = cola.get( 0 );
		cola.remove( p );
		wait();
		return 	p;	
		
	}
	
	/** Encola la persona al final de la cola
	 */
	public synchronized void insertar( Persona persona){
		this.cola.add( persona );
		notifyAll();
	}
	
	/** Encola la persona al final de la cola
	 */
	public boolean estaVacia(){ 
		return cola.isEmpty();		
	}
	
	
	/**
	 * Demostracion y prueba de la cola
	 */
	public static void main(String[] args) {
		Persona p1 = new Persona ( "11111111A","Antonio","Abad","Albatera");
		Persona p2 = new Persona ( "22222222B","Beatriz","Bou","Bayo");
		Persona p3 = new Persona ( "33333333C","Carlos","Catala","Cherza");
		
		Cola c = new Cola();
		c.insertar( p1 );
		System.out.println ( c.toString() );
		c.insertar( p2 );
		System.out.println ( c.toString() );
		c.insertar( p3 );
		System.out.println ( c.toString() );
		
		try {
			Persona pp1 = c.extraer();
			System.out.println( "Hemos sacado " + pp1.toString() );
			System.out.println( "La cola ha quedado" );
			System.out.println ( c.toString() );
			
			Persona pp2 = c.extraer();
			Persona pp3 = c.extraer();
			System.out.println( "La cola ha quedado" );
			System.out.println ( c.toString() );
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
		
	

	}

	@Override
	public String toString() {
		String texto = "Cola: ";
		for (Persona p : cola) {
			texto += "\n\t" + p.toString();
		}
						
		return texto;
	} 

	 
	
	
	

}
