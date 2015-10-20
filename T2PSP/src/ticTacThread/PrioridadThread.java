package ticTacThread;


import java.text.DecimalFormat;

public class PrioridadThread extends Thread {
	
	private double contador; // double para no pasarnos del valor
	
	

	@Override
	public void run() {
		while (true) {
			// hacemos que el hilo trabaje para nada
			for (int i = 0; i < 100; ) {
				i++; 
			}
			// contamos como interacion
			this.contador++; 
		}
	}

	public PrioridadThread() {
		super();
		this.contador = 0;
	}
	


	@Override
	public String toString() {
		
		DecimalFormat df = new DecimalFormat("#.##");
		
		return "PrioridadThread ["				
				+ getName() + "]" 
				+ "priodidad[ " + getPriority()+ "]"  
				
				+ "contador = " + df.format( this.contador ) + "]";
	}
	

}
