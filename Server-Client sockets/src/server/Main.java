package server;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Server serv = new Server();
        System.out.println("Inicia Servidor");

        //Inicia servidor
        serv.iniciarServer();
        //Finaliza servidor
        serv.finalizarServer();
    }

}