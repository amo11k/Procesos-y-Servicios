package contadorSincrnized;

public class InterferenciaTest {

	public static void main(String[] args) {
		Contador contador = new Contador( 0 );
		Incrementador inc1 = new Incrementador("Incrementador1", contador );		
		Incrementador inc2 = new Incrementador("Incrementador2", contador );
		Decrementador dec1 = new Decrementador("Decrementador1", contador );
		Decrementador dec2 = new Decrementador("Decrementador2", contador );
		
		inc1.start();
		inc2.start();
		dec1.start();
		dec2.start();

	}

}
