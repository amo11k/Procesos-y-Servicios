package productorConsumidor;

public class ProductorConsumidorTest {

	public static void main(String[] args) {
		// Creacion de la cola
		Cola cola = new Cola();

		// Productores
		Thread encolador_1 = new Thread(new Encolador("Encolador_1", cola));
		encolador_1.start();

		Thread encolador_2 = new Thread(new Encolador("Encolador_2", cola));
		encolador_2.start();

		// Consumidores
		Thread cajero_1 = new Thread(new Cajero("Cajero_1", cola));
		cajero_1.start();

		Thread cajero_2 = new Thread(new Cajero("Cajero_2", cola));
		cajero_2.start();

	}

}
