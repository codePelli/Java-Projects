package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class Client {

    private final String HOST = "localhost";
    private final int PUERTO = 9876;
    private Socket socket;
    Scanner sc = new Scanner(System.in);

    public Client() throws IOException{
        socket = new Socket(HOST, PUERTO);
    }

    public void iniciarClient() throws IOException {

        DataInputStream entradaServer = new DataInputStream(socket.getInputStream());
        System.out.println(entradaServer);

        DataOutputStream salidaServer = new DataOutputStream(socket.getOutputStream());
        System.out.println("Escribe tu nombre");
        String nombre = sc.next();
        salidaServer.writeUTF(nombre);
        System.out.println("Numero de tareas a realizar");
        int tareas = sc.nextInt();
        salidaServer.writeInt(tareas);
        for (int i = 0; i <= tareas; i++) {
            System.out.println(entradaServer.readUTF());
            System.out.println(entradaServer.readUTF());
            String descripcionTarea = sc.next();
            salidaServer.writeUTF(descripcionTarea);
            System.out.println(entradaServer.readUTF());
            String estadoTarea = sc.next();
            salidaServer.writeUTF(estadoTarea);
        }

        System.out.println(entradaServer.readUTF());

		/*Random random = new Random();
		int numAleatorio = random.nextInt(5)+3;
		for (int i = 0; i < numAleatorio; i++) {
			salidaServer.writeUTF("Este es el mensaje numero: " + i);

		}*/

        salidaServer.close();
        entradaServer.close();
        socket.close();

    }

}
