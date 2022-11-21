package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

    //Conexión
    private final int PUERTO = 9876;
    private ServerSocket serverSocket;
    private Socket socket;

    //Constructor conexión
    public Server() throws IOException {
        serverSocket = new ServerSocket(PUERTO);
        socket = new Socket();
    }

    //Inicio de la conexión
    public void iniciarServer() throws IOException{

            System.out.println("Esperando a la conexión del cliente");
            socket = serverSocket.accept();

            //DataOutputStream mensajeCliente = new DataOutputStream(socket.getOutputStream());

            //mensajeCliente.writeUTF("Peticion recibida");

            DataInputStream entrada = new DataInputStream(socket.getInputStream());

            System.out.println("Nombre del cliente");
            String nombre = entrada.readUTF();
            DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
            System.out.println("Nombre del cliente: " + nombre);
            System.out.println("Numero de tareas");
            int tareas = entrada.readInt();
            System.out.println("Tareas a ralizar " + tareas);
            ArrayList<Tarea> lista_tareas = new ArrayList<Tarea>();
            for (int i = 0; i < tareas; i++) {
                salida.writeUTF("Tarea número: " + (i+1));

                salida.writeUTF("Descripción de la tarea");
                String descripcion = (entrada.readUTF());
                salida.writeUTF("Estado de la tarea");
                String estado = (entrada.readUTF());

                lista_tareas.add(new Tarea(descripcion, estado));
            }

            System.out.println("Las tareas a realizar son: " + lista_tareas);
            salida.writeUTF("Las tareas son: " + lista_tareas);

            socket.close();
            entrada.close();
            salida.close();

            System.out.println("El servidor envía las tareas a realizar");

    }

    public void finalizarServer() throws IOException{
        serverSocket.close();
        System.out.println("Servidor cerrado");
    }
}
