package chatClienteServidor;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class AppCliente {

	private static final String HOST = "localhost";
	private static final int PUERTO = 4444;
	private static String mensaje;
	private static Scanner ky = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
		

		Socket clientSocket = new Socket(HOST, PUERTO);

		DataOutputStream salida = new DataOutputStream(clientSocket.getOutputStream());

		System.out.print("INTRODUZCA EL NOMBRE DE USUARIO => ");
		String nombre = ky.nextLine();
		salida.writeUTF(nombre);

		AtiendeServidor cliente = new AtiendeServidor(clientSocket);

		cliente.start();

		while (true) {

			mensaje = ky.nextLine();
			salida.writeUTF(mensaje);
		}

	}

}
