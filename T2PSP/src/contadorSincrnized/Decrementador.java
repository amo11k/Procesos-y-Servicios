package contadorSincrnized;

public class Decrementador extends Thread{
		
	private Contador contador;
	
	
	Decrementador ( String nombre, Contador c){
		setName( nombre );
		this.contador = c;
	}
	
	public void run(){
		int valor_inicial = contador.getContador();
		// hacemos que el hilo trabaje para nada		
		for (int i = 0; i < 300; i++) {
			contador.decrementar();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}			
		}
		System.out.println ( toString() + " el valor inicial era " + valor_inicial );				
	}

	@Override
	public String toString() {
		return "Decrementador [" + getName() + " contador=" + contador.getContador() + "]";
	}
	

}
