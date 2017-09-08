import java.util.ArrayList;
import miPaquete.Fecha;
public class Ticket {
	private int nro;
	private Fecha fecha;
	private ArrayList<Consumo> consumos;
	private byte nroMesa;
	private Mozo mozo;
	private float total;
	
	public Ticket (int val1, byte val2, Mozo m) {
		nro			= val1;
		fecha 		= Fecha.hoy();
		consumos 	= new ArrayList<Consumo>();
		nroMesa 	= val2;
		total 		= 0;
		mozo 		= m;
	}
	
	public boolean sosMesa(byte nro) {
		return nroMesa == nro;
	}
	
	public boolean estaAbierto() {
		return total == 0;
	}
	
	public boolean sosDeMozo(Mozo m) {
		return mozo == m;
	}
	
	public Fecha darFecha() {
		return fecha;
	}

	public int darNumeroTicket() {
		return nro;
	}
	
	
	public void agregarConsumo(Consumo cons) {
		consumos.add(cons);
	}
	
	

}
