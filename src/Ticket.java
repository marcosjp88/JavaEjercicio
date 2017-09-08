import java.util.ArrayList;
import miPaquete.Fecha;
public class Ticket {
	private int nro;
	private Fecha fecha;
	private ArrayList<Consumo> consumos;
	private byte nroMesa;
	private Mozo mozo;
	private int maxMesas;
	private float total;
	
	public Ticket (int val1, byte val2, Mozo m) {
		nro			= val1;
		fecha 		= Fecha.hoy();
		consumos 	= new ArrayList<Consumo>();
		nroMesa 	= val2;
		maxMesas	= 20;
		total 		= 0;
		mozo 		= m;
	}
	
	public boolean sosMesa(byte nro) {
		return nroMesa == nro;
	}
	
	public boolean estaAbierto() {
		return total == 0;
	}
	
	public boolean sosDeMesa(Mozo m) {
		return mozo == m;
	}
}
