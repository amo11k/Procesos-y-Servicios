package procesos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LanzadorSecuencial {

	public static void main(String args[]) throws InterruptedException {
		// creamos el comando
		String textoComando = "ping 127.0.0.1 -c 1 -w 3";
		// windows: ping 127.0.0.1 -n 1 -w 3000
		// linux: ping 127.0.0.1 -c 1 -w 3
		String[] comandoArgs = textoComando.split(" ");

		Process process;
		// Este programa realiza varios pings sobre una maquina
		for (int i = 0; i < 5; i++) {
			try {
				process = new ProcessBuilder(comandoArgs).start();
				int res = process.waitFor(); // waitfor() Causes the current
												// thread to wait, if necessary,
												// until the process represented
												// by this Process object has
												// terminated. This method
												// returns if the subprocces
												// have terminated or not yet.
				System.out.println("Ping num:  " + i + "... lanzado!");
				System.out.println("El ping ha acabado: Bien! - " + res);
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
		} // for

	}// main
}
