package chatClienteServidor;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class ComunHilos {

	private int MAX_CONEXIONES, conexionesTotales, conexionesActuales;
	private String mensajes;
	private static ArrayList<Socket> tablaDeConexiones = new ArrayList<Socket>();

	public ComunHilos(int MAX_CONEXIONES) {
		this.MAX_CONEXIONES = MAX_CONEXIONES;
	}

	public int getConexionesTotales() {
		return conexionesTotales;
	}

	public int getConexionesActuales() {
		return conexionesActuales;
	}

	public String getMensajes() {
		return mensajes;
	}

	public synchronized void aniadir(Socket conexion) {

		tablaDeConexiones.add(conexion);

	}

	public synchronized void aniadir(String mensaje, String nombreUsuario) {

		for (Socket sc : tablaDeConexiones) {
			DataOutputStream out = null;
			try {
				out = new DataOutputStream(sc.getOutputStream());
				out.writeUTF(mensaje);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
