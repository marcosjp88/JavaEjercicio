import java.util.Scanner;
import java.util.ArrayList;

public class Bar {
	private int cuit;
	private String razonSocial;
	private ArrayList<Ticket> tickets;
	private ArrayList<Mozo> mozos;
	private ArrayList<Producto> productos;
	private int maxMesas;
	public Bar(int val, String str) {
		cuit 			= val;
		razonSocial 	= str;
		tickets 		= new ArrayList<Ticket>();
		mozos 			= new ArrayList<Mozo>();
		productos 		= new ArrayList<Producto>();
		maxMesas 		= 20;
	}
	
	Public void abrirMesa() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Ingrese nro de mesa");
		byte nroMesa = entrada.nextByte();
		if((nroMesa < 1) || (nroMesa > maxMesas))
	}
}
