package co.edu.unbosque.view;

import java.io.OutputStream;
import java.io.PrintWriter;

public class Salida {

	private PrintWriter print;
	
	public Salida (OutputStream print) {
		this.print=new PrintWriter(print,true);
	}
	
	public void conSalto (String msj) {
		System.out.println(msj);
	}
	
	public void sinSalto (String msj) {
		System.out.print(msj);
	}
	
	public void enviarImpri(String msj) {
		print.println(msj);
	}

	public PrintWriter getPrint() {
		return print;
	}

	public void setPrint(PrintWriter print) {
		this.print = print;
	}
	
	public static void mostrar (String msj) {
		System.out.println(msj);
	}
}
