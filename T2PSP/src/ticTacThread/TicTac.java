package ticTacThread;

import PrioridadThread.PrioridadThread;

public class TicTac extends Thread implements Runnable {
	private int contador;

	public TicTac() {
		super();
		contador=0;
	}
	
	public int getContador(){
		return this.contador;
	}

	@Override
	public void run() {
		while (true) {
			System.out.println(getName()+" ["+getPriority()+"] "+getContador());
			this.contador++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public String toString() {
		return "El proceso " + getName() + " con prioridad " + getPriority() + ". Contador: " + getContador();
	}

	public static void main(String[] args) {
		TicTac t1, t2;

		t1 = new TicTac();
		t1.setName("Tic");
		t1.setPriority(Thread.MIN_PRIORITY);
		
		t2 = new TicTac();
		t2.setName("Tac");
		t2.setPriority(Thread.MAX_PRIORITY);
	
		t2.start();
		t1.start();

		/*try {
			while (true) {
				//t1.sleep(1000);
				//t2.sleep(1000);
				//System.out.println(t2.toString());				
				//System.out.println("======================================");
				//System.out.println(t1.toString());
				//System.out.println("======================================");				
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/

	}
}