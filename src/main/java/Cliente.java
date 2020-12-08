// Librerías
import java.io.*;
import java.net.*;

/**
 * Clase cliente que conecta al Servidor
 * @author Davibern
 * @version 1.0
 */
public class Cliente {

    // Atributos de clase
    private static final String HOST = "localhost";
    private static final int PUERTO = 2000;

    /**
     * Constructor de clase
     */
    public Cliente() {

        try {
            Socket cliente = new Socket(HOST, PUERTO);
            InputStream aux = cliente.getInputStream();
            DataInputStream flujoEntrada = new DataInputStream(aux);
            System.out.println(flujoEntrada.readUTF());
            cliente.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    /**
     * Lanzador del programa
     * @param args
     */
    public static void main(String[] args) {
        new Cliente();
    }

}
