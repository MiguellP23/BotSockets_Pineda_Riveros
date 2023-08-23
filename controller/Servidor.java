package co.edu.unbosque.controller;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import co.edu.unbosque.model.Bot;
import co.edu.unbosque.view.Entrada;
import co.edu.unbosque.view.Salida;

public class Servidor {
	
	private final int PORT = 8000;
	private Entrada en;
	private Salida sal;
	private Bot bot;
	private Socket so;
	private ServerSocket ss;
	
	public Servidor() {
		try {
			bot = new Bot();
			ss = new ServerSocket(PORT);
			
		}catch(IOException e) {
			System.err.println("Error");
		}
		
		
	}
	
	public void startServidor() {
		try {
			Salida.mostrar("Servidor en linea");
			so = ss.accept();
			en = new Entrada(so.getInputStream());
			sal = new Salida (so.getOutputStream());
			
			String mensaje, respuesta;
			while((mensaje = en.readString())!=null) {
				respuesta = bot.generateResponse(mensaje);
				sal.conSalto("Message cliente "+mensaje);
				sal.conSalto("Message bot "+respuesta);
				sal.enviarImpri(respuesta);
			}
			
			en.getEn().close();
			sal.getPrint().close();
			so.close();
			ss.close();
			
		}catch (IOException e) {
			System.out.println("Error");
		}
	}

}
