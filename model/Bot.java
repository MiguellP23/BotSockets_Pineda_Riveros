package co.edu.unbosque.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;

import co.edu.unbosque.model.persistence.FileHandler;

public class Bot {

	private HashMap<String, String> lrespuesta;

	public Bot() {
		lrespuesta = leerArchivo();
	}

	public String generateResponse(String question) {
		if (!question.matches(".*[^()0-9+\\-*/\\., ].*")) {
			question = question.replace(",", ".").replaceAll("\\s+", "");
			question = question.replace(")(", ")*(");

		} else {
			String compile = question.trim().toLowerCase().replaceAll("[^a-z]", "");
			if (lrespuesta.containsKey(compile)) {
				String response = lrespuesta.get(compile);
				if (response.equals("El dia de hoy es"))
					response += (" " + LocalDate.now().toString() + ".");
				else if (response.equals("La hora actual es")) {
					response += (" " + LocalTime.now().toString() + ".");
					response = response.substring(0, response.lastIndexOf(":"));
				}
				return response;
			}
		}
		return "Lo lamento no tengo respuesta para lo que acabas de introducir.";
	}

	private HashMap<String, String> leerArchivo() {
		HashMap<String, String> aux = new HashMap<>();
		String[] lineas = FileHandler.leerTextFile("respuestas.txt").split("\n");
		for (String linea : lineas) {
			int sep = linea.indexOf(":");
			String[] ques = linea.substring(0, sep).split(",");
			String res = linea.substring(sep + 1);
			for (String s : ques)
				aux.put(s, res);
		}
		return aux;
	}

}
