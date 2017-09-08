import java.util.Scanner;

import miPaquete.Fecha;

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
	
	public void abrirMesa() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Ingrese nro de mesa");
		byte nroMesa = entrada.nextByte();
		if((nroMesa < 1) || (nroMesa > maxMesas)) {
			System.out.println("numero de mesa erroneo");
		} else {
			if(this.estaAbiertoMesa(nroMesa)) {
				System.out.println("error - Mesa ocupada");
			} else {
				Mozo m = this.asignarMozo();
				if (m == null) {
					System.out.println("Error - no hay mesas");
				} else {
					int nroTicket = 0;
					if (tickets.size() > 0) {
						nroTicket = tickets.get(tickets.size()-1).darNumeroTicket();
					} else {
						nroTicket++;
						Ticket t = new Ticket(nroTicket, nroMesa, m);
						tickets.add(t);
					}
				}
			}
			
		}
	}
	
	public Mozo asignarMozo() {
		if(mozos.isEmpty()) {
			return null;
		} else {
			Mozo menorMozo = mozos.get(0);
			int menorMesas = this.mesasAbiertasMozo(menorMozo);
			int cantMesas;
			for(Mozo m:mozos) {
				cantMesas = this.mesasAbiertasMozo(m);
				if(cantMesas < menorMesas) {
					menorMozo = m;
					menorMesas = cantMesas;
				}
			}
			return menorMozo;
		}
	}
	
	public int mesasAbiertasMozo(Mozo m) {
		int cantMesasAbiertas = 0;
		int i = tickets.size() - 1;
		while((i >= 0 && (tickets.get(i).darFecha().esIgualA(Fecha.hoy())))) {
			if((tickets.get(i).sosDeMozo(m)) && (tickets.get(i).estaAbierto())) {
				cantMesasAbiertas++;
			}
			i--;
		}
		return cantMesasAbiertas;
	}
	
	public boolean estaAbiertoMesa(byte nro) {
		if (tickets.isEmpty()) {
			return false;
		} else {
			int i = tickets.size() - 1;
			while((i >= 0) && (tickets.get(i).sosMesa(nro))) {
				i--;
			}
			if(i >= 0) {
				return tickets.get(i).estaAbierto();
			} else {
				return false;
			}
		}
	}
	
	
	
	public void agregarMozo() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Ingrese nro de legajo");
		int legajoNuevo = entrada.nextInt();
		Mozo m = this.buscarMozo(legajoNuevo);
		if(m != null) {
			System.out.println("Error - ese mozo ya existe");
		} else {
			System.out.println("Ingrese nro de dni");
			int dni = entrada.nextInt();
			System.out.println("Ingrese el nombre");
			String nombre = entrada.next();
			m = new Mozo(legajoNuevo, dni, nombre);
			mozos.add(m);
		}
	
	}
	
	public Mozo buscarMozo(int leg) {
		int i = 0;
		while((i < mozos.size()) && (!mozos.get(i).sosMozo(leg))) {
			i++;
		}
		if(i != mozos.size()) {
			return mozos.get(i);
		} else {
			return null;
		}
	}
	
	public void AgregarProducto() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Ingrese nro de codigo");
		int codN = entrada.nextInt();
		Producto p = this.buscarProducto(codN);
		if(p != null) {
			System.out.println("Error - ese producto ya existe");
		} else {
			System.out.println("Ingrese el precio unitario");
			float precioU = entrada.nextFloat();
			System.out.println("Ingrese la Descripcion");
			String descr = entrada.next();
			p = new Producto(codN, descr, precioU);
			productos.add(p);
		}
	}
	
	public Producto buscarProducto(int codP) {
		int i = 0;
		while((i < productos.size()) && (!productos.get(i).sosProducto(codP))) {
			i++;
		}
		if(i != productos.size()) {
			return productos.get(i);
		} else {
			return null;
		}
	}

	
	public void agregarConsumo() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Ingrese nro de mesa");
		byte nroMesa = entrada.nextByte();
		Ticket m = this.buscarTicket(nroMesa);
		if(m == null) {
			System.out.println("la mesa es incorrecta");
		} else {
			System.out.println("Ingrese el codigo de producto");
			int codN = entrada.nextInt();
			Producto p = this.buscarProducto(codN);
			if(p == null) {
				System.out.println("Error el producto no indicado");
			} else {
				System.out.println("Ingrese la cantidad");
				int cant = entrada.nextInt();
				Consumo c = new Consumo(p,cant);
				m.agregarConsumo(c);
			}
		}
	}
	
	public Ticket buscarTicket(int nroMesa) {
		
	}
	
	
	
}
