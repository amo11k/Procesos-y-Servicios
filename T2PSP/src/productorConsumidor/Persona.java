package productorConsumidor;

public class Persona {
	public String DNI;
	public String nombre;
	public String apellido1;
	public String apellido2;	
	
	public Persona(String dNI, String nombre, String apellido1,
			String apellido2){
		super();
//		if (DNI == null | DNI.length() != 9 ){
//			throw new Exception("Persona.constructor: DNI Incorrecto ");
//		}
		DNI = dNI;
		
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;		
	}

	@Override
	public String toString() {
		return "Persona [DNI=" + DNI + ", nombre=" + nombre + ", apellido1="
				+ apellido1 + ", apellido2=" + apellido2 + "]";
	}	
}
