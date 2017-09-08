import java.util.Scanner;

public class claseCordinadora {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bar a = new Bar(1234, "El bar de enfrente");
		Scanner entrada = new Scanner(System.in);
		byte opc;
		do
		{
			System.out.println("\n BIENVENIDO AL BAR DE ENFRENTE!");
			// se visualiza cada linea independiente con un propio mensaje
			System.out.println("\nIngrese la opcion que desea realizar");
			System.out.println("\n1-> Agregar a un Mozo" +
					"\n2-> Agregar un producto" +
					"\n0->Salir.");
			// se visualiza de a una linea pero en un solo mensaje
			opc = entrada.nextByte();
			switch(opc)
			{
			case 1:
			{
				a.agregarMozo();
			}
				break;
			case 2:
			{
				//
			}
				break;
			case 3:
			{
				//
			}
				break;
		   default:
				break;
			}
		}
		while(opc != 0);
	}

}
