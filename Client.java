import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {

		Socket socket = null;
		InputStreamReader inputStreamReader = null;
		OutputStreamWriter outputStreamWriter = null;
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;

		try {

			socket = new Socket("localhost", 8080);

			inputStreamReader = new InputStreamReader(socket.getInputStream());
			outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());

			bufferedReader = new BufferedReader(inputStreamReader);
			bufferedWriter = new BufferedWriter(outputStreamWriter);

			Scanner sc = new Scanner(System.in);

			while (true) {

				String msgToSend = sc.nextLine();

				bufferedWriter.write(msgToSend);
				bufferedWriter.newLine();
				bufferedWriter.flush();

				System.out.println("Server: " + bufferedReader.readLine());

				if (msgToSend.equalsIgnoreCase("Adios")) 
					break;
		
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (socket != null)
					socket.close();

				if (inputStreamReader != null)
					inputStreamReader.close();

				if (outputStreamWriter != null)
					outputStreamWriter.close();

				if (bufferedReader != null)
					bufferedReader.close();
				if (bufferedWriter != null)
					bufferedWriter.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}

	}

}