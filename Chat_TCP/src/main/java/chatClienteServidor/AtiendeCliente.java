package chatClienteServidor;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class AtiendeCliente extends Thread {

	private Socket socket;
	private String usuario;
	private ComunHilos comunHilos;

	public AtiendeCliente(Socket client, ComunHilos ch) {
		this.usuario = "";
		this.socket = client;
		this.comunHilos = ch;
	}

	@Override
	public void run() {
		super.run();
		try {
			comunHilos.aniadir(socket);
			DataInputStream entrada = new DataInputStream(socket.getInputStream());
			usuario = entrada.readUTF();
			
			System.out.println("[" + usuario + "] => " + entrada.readUTF());
			
			while (true) {
				String mensajeDelCliente = entrada.readUTF();
				System.out.println("[" + usuario + "] => " + mensajeDelCliente);
				comunHilos.aniadir(mensajeDelCliente, usuario);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
