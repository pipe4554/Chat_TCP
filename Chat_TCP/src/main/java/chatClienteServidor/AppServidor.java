package chatClienteServidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class AppServidor {

	private static final int PUERTO = 4444;
	private static final int MAX_CONEXIONES = 2;
	private static ServerSocket servidor;
	public static void main(String[] args) throws IOException {
		servidor = new ServerSocket(PUERTO);

		System.out.println("Inicio de aplicación en el puerto " + PUERTO);
		ComunHilos comunHilos = new ComunHilos(MAX_CONEXIONES);
		while (true) {

			Socket socketCliente = servidor.accept();
			AtiendeCliente atiendeCliente = new AtiendeCliente(socketCliente, comunHilos);
			System.out.println("Nuevo cliente");
			atiendeCliente.start();

		}

	}

}
