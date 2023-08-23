package co.edu.unbosque.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Entrada {
	
	private BufferedReader br;
	
	public Entrada (InputStream br) {
		this.br = new BufferedReader(new InputStreamReader(br));
	}
	
	public BufferedReader getEn() {
		return br;
	}
	
	public void getEn(BufferedReader br) {
		this.br = br;
	}
	
	public String readString() throws IOException{
		return br.readLine();
	}

}
