package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileHandler {

	private static Scanner lector;
	private static File file;

	public FileHandler() {
		// TODO Auto-generated constructor stub
	}

	public static String leerTextFile(String path) {
		StringBuffer sb = new StringBuffer();
		file = new File("src/co/edu/unbosque/model/persistence/" + path);
		try

		{
			lector = new Scanner(file);
			while (lector.hasNextLine()) {
				sb.append(lector.nextLine() + "\n");
			}
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no existente");
			e.printStackTrace();

		}
		return sb.toString();
	}
}