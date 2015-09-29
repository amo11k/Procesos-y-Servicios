package ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PSShell {

	public static void main(String[] args) throws IOException {
		
		System.out.println("What program do you want to run? (Type -1 for exit)");
		String programName = new BufferedReader(new InputStreamReader(System.in)).readLine();

		if (programName == "-1") {
			System.out.println("The program closes correctly");
			System.exit(0);
		} else {
			ProcessBuilder pb = new ProcessBuilder(programName);
			try {
				Process process = pb.start();
				int retorno = process.waitFor();
				System.out.println("La ejecución de " +programName + " devuelve " + retorno);
				System.out.println("Salida del proceso " +programName + ":");
				InputStream is = process.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				String line;
				while ((line = br.readLine()) != null) {
					System.out.println(line);
				}
			} catch (IOException ex) {
				System.err.println("Excepción de E/S!!");
				System.exit(-1);

			} catch (InterruptedException ex) {
				System.err.println("El proceso hijo finalizó de forma incorrecta");
				System.exit(-1);

			}
		}

	}

}
