
public class Consumo {
	private Producto producto;
	private int cant;
	private float importe;
	
	public Consumo(Producto prod, int valor) {
		producto 	= prod;
		cant 		= valor;
		importe = prod.valorizar(cant);
	}
	
	public float darCosto() {
		return importe;
	}
	
	public void mostrarse() {
		producto.mostrarDescripcion();
		producto.mostrarPrecioUnitario();
		this.mostrarCantidad();
		this.mostrarTotal();
	}
	
	public void mostrarTotal() {
		System.out.println("subtotal: " + importe);
	}
	public void mostrarCantidad() {
		System.out.print(" cantidad: " + cant);
	}
 }
