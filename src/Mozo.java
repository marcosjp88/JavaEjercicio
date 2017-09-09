
public class Mozo {
	private int legajo;
	private int dni;
	private String nombre;
	
	public Mozo(int val1, int val2, String str) {
		legajo 	= val1;
		dni 	= val2;
		nombre	= str;
	}
	
	public boolean sosMozo(int leg) {
		return leg == legajo;
	}

	public String darNombre() {
		return nombre;
	}
	
}
