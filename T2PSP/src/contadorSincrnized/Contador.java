package contadorSincrnized;

public class Contador {
	private int c = 0;
	
	Contador (int c){
		this.c = c;
	}
	
	public synchronized void incrementar(){
		c++;
	}
	
	public synchronized void decrementar(){
		c--;
	}
	
	public int getContador(){
		return c;
	}

}
