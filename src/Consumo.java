
public class Consumo {
	private Producto producto;
	private int cant;
	private float importe;
	
	public consumo(Producto prod, int valor) {
		producto = prod;
		cant = valor;
		importe = prod.valorizar(cant);
	}
}
