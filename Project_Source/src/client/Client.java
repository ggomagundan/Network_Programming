package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client implements Runnable {

	private Socket socket;
	private BufferedReader bufferedReader;
	private PrintWriter printWriter;
	private static BufferedReader bufferRead = new BufferedReader(
			new InputStreamReader(System.in));
	private static String nickName = null;
	
	public Client() {

		try {
			
			System.out.println("대화명을 입력해주세요.");
			nickName = bufferRead.readLine();
			
			socket = new Socket("117.17.158.171", 9995);
			bufferedReader = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			printWriter = new PrintWriter(new OutputStreamWriter(
					socket.getOutputStream()));
			
			Thread thread = new Thread(this);
			thread.start();

			while (true) {
				try {
					String msg = bufferedReader.readLine();
					if (msg == null || msg.equals("null")) {
						socket.close();
						System.exit(0);
						throw new IOException("Network Failed");
					}
					System.out.println(msg);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (bufferedReader != null)
					bufferedReader.close();
			} catch (Exception ignored) {
			}
			try {
				if (printWriter != null)
					printWriter.close();
			} catch (Exception ignored) {
			}
			try {
				if (socket != null)
					socket.close();
			} catch (Exception ignored) {
			}
		}
	}

	public void run() {
		while (true) {
			try {
				String msg = bufferRead.readLine();
				printWriter.println(nickName + " ( "
						+ InetAddress.getLocalHost().getHostAddress() + " ) "
						+ "> " + msg);
				printWriter.flush();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new Client();
	}
}
