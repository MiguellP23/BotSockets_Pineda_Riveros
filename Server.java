import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
	private static List<String> respuestas = new ArrayList<>();
	
	static {
		respuestas.add("Hola, en que puedo ayudarte");
		respuestas.add("Bienvenido! como puedo asistirte?");
	}
	
	
	public static void main(String[] args) throws IOException {
		
		Socket socket = null;
		InputStreamReader inputStreamReader = null;
		OutputStreamWriter outputStreamWriter = null;
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		ServerSocket serverSocket = null;
		
		serverSocket = new ServerSocket(8080);
		System.out.println("Servidor conectado");
		
		while (true) {
			
			try {
				
				socket = serverSocket.accept();
				System.out.println("Nuevo cliente conectado: " + socket.getInetAddress().getHostAddress());
				
				inputStreamReader = new InputStreamReader(socket.getInputStream());
				outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
				
				bufferedReader = new BufferedReader(inputStreamReader);
				bufferedWriter = new BufferedWriter(outputStreamWriter);
				
				while (true) {
					
					String msgFromClient = bufferedReader.readLine();
					
					System.out.println("Cliente: " +msgFromClient);
					
					bufferedWriter.write("Mensaje recibido");
					bufferedWriter.newLine();
					bufferedWriter.flush();
					
					if (msgFromClient.equalsIgnoreCase("Adios")) 
						break;
					
				}
				
				socket.close();
				inputStreamReader.close();
				outputStreamWriter.close();
				bufferedReader.close();
				bufferedWriter.close();
				
			} catch (Exception e) {
				
			}
		}
	}
}
