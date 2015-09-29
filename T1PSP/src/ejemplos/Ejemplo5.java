package ejemplos;

import java.io.*;

public class Ejemplo5 {
	public static void main(String[] args) {
		Runtime r = Runtime.getRuntime();
		String comando = "java Ejemplolectura";
		Process p = null;

		try {
			p = r.exec(comando);
			// Escritura
			OutputStream os = p.getOutputStream();
			os.write("Hola Manuel\n".getBytes());
			os.flush(); // Vacia el buffer de salida
			// Lectura
			InputStream is = p.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String linea;
			while ((linea = br.readLine()) != null)
				System.out.println(linea);
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Comprobación de error 0 bien -1 mal
		int exitVal;
		try {
			exitVal = p.waitFor();
			System.out.println("Valor de Salida: " + exitVal);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}