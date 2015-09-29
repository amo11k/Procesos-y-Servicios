package ejemplos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class UnixInteractor {
	public static void main(String[] command) {
		String line;
		// Preparamos el commando a ejecutar
		ProcessBuilder pb = new ProcessBuilder(command);
		pb.redirectErrorStream(true);
		try {
			// Se crea el Nuevo proceso hijo
			Process shell = pb.start();
			// Se obtiene stdout del proceso hijo
			InputStream is = shell.getInputStream();
			// Se convierte el formato de UTF-8 al de un String de Java
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			System.out.println("La salida del proceso hijo" + Arrays.toString(command) + ":");
			// Se muestra la salida del hijo por pantalla
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			// Cuando finaliza se cierra el descriptor
			// de salida del hijo
			is.close();
		} catch (IOException e) {
			System.out.println("Error ocurrió ejecutando el comando. Descripción:" + e.getMessage());
		}
	}
}
