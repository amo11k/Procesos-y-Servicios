package pizza;

public class PizzaTest {

	public static void main(String[] args) {
		// Creacion de la cola
		Horno horno = new Horno();
		
		// Productores
		Thread pizzaWeb_1 = new Thread( new PizzaWeb( "1_Pizza.com", horno ) );
		pizzaWeb_1.start();
					
		Thread pizzaWeb_2 = new Thread( new PizzaWeb( "2_Pizza.es", horno ) );
		pizzaWeb_2.start();
		
		
		
					
		// Consumidores
		Thread repartidor_1 = new Thread( new Repartidor( "Repartidor_1", horno ) );
		repartidor_1.start();
		
		Thread repartidor_2 = new Thread( new Repartidor( "Repartidor_2", horno ) );
		repartidor_2.start();
		
		Thread repartidor_3 = new Thread( new Repartidor( "Repartidor_3", horno ) );
		repartidor_3.start();
		
//		Thread repartidor_4 = new Thread( new Repartidor( "Repartidor_4", horno ) );
//		repartidor_4.start();
//		
//		Thread repartidor_5 = new Thread( new Repartidor( "Repartidor_5", horno ) );
//		repartidor_5.start();
	}

}
