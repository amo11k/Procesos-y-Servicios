package procesos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProcesoSalida {

	public static void main(String args[]) throws InterruptedException {
		// creamos el comando
		String textoComando = "echo bla bla bla bla";
		String[] comandoArgs = textoComando.split(" ");
		

		Process process;
		try {
			process = new ProcessBuilder( comandoArgs ).start();;
			int retorno = process.waitFor();
			System.out.println("La ejecución del programa " +textoComando + " devuelve " + retorno);
			System.out.println("Salida del proceso " +textoComando + ":");
			InputStream is = process.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		
		System.out.println("El programa ha terminado ");

	}
}
