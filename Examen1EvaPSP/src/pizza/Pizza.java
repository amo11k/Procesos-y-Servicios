package pizza;

public class Pizza {
	
	public String nombre;
	public String tamanyo;
	public String oferta;	
	public String ingredientes;	
	
	public Pizza(String nombre, String tamanyo,
			String ingredientes, String oferta){
		super();//		
		this.oferta = oferta;		
		this.nombre = nombre;
		this.tamanyo = tamanyo;
		this.ingredientes = ingredientes;		
	}

	@Override
	public String toString() {
		return "Pizza [oferta=" + oferta + ", nombre=" + nombre + ", tamanyo="
				+ tamanyo + ", ingredientes=" + ingredientes + "]";
	}
		
}
