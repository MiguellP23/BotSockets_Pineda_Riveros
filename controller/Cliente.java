package co.edu.unbosque.controller;

import java.io.IOException;
import java.net.Socket;

import co.edu.unbosque.view.Entrada;
import co.edu.unbosque.view.Salida;

public class Cliente {

	private final int PORT = 8000;
	private final String HOST = "127.0.0.1";

	private Salida sal;
	private Entrada enS, enC;
	private Socket so;

	public Cliente() {
		try {
			so = new Socket(HOST, PORT);
		} catch (IOException e) {
			System.out.println("Se ha producido un error");
		}
	}

	public void startCliente() {
		try {
			enS = new Entrada(so.getInputStream());
			sal = new Salida(so.getOutputStream());
			enC = new Entrada(System.in);
			String mensaje, respuesta;
			Salida.mostrar("Bienvenido al Bot de Miguel Pineda ; Yishaq Riveros\n"
					+ "Bot destinado a responder sus dudas sobre la Formula 1\n"
					+ "Para salir de nuestro bot escriba salir. \n");

			do {
				sal.sinSalto("Message: ");
				mensaje = enC.readString();
				sal.enviarImpri(mensaje);
				respuesta = enS.readString();
				sal.conSalto("Answer: " + respuesta);
			} while (!respuesta.equalsIgnoreCase(" Gracias por usar el programa y aprender de Formula 1"));
			enS.getEn().close();
			sal.getPrint().close();
			enC.getEn().close();
			so.close();

		} catch (IOException e) {
			System.out.println("Se ha producido un error");
		}
	}
}
