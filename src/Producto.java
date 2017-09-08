
public class Producto {
	private int cod;
	private String descripcion;
	private float precioUnit;
	
	public Producto(int val1, String str, Float val2) {
		cod 		= val1;
		descripcion = str;
		precioUnit	= val2;
	}
	
	public float valorizar(int cant) {
			return cant * precioUnit;
	}
}
