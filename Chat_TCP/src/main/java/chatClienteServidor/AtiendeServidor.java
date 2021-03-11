package chatClienteServidor;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class AtiendeServidor extends Thread {

	private Socket socket;

	public AtiendeServidor(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		super.run();

		try {

			while (true) {
				DataInputStream entrada = new DataInputStream(socket.getInputStream());
				System.out.println(entrada.readUTF());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}