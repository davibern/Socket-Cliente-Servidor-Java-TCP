// Librerías
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Clase servidor que atenderá peticiones del cliente
 * @author Davibern
 * @version 1.0
 */
public class Servidor {

    // Atributos de clase
    private static final int PUERTO = 2000;

    /**
     * Constructor de la clase Servidor
     */
    public Servidor() {

        try {
            ServerSocket server = new ServerSocket(PUERTO);

            System.out.println("Escucho el puerto " + PUERTO);

            for (int i = 0; i < 3; i++) {
                Socket cliente = server.accept();
                System.out.println("Sirvo al cliente " + i);
                OutputStream aux = cliente.getOutputStream();
                DataOutputStream flujoSalida = new DataOutputStream(aux);
                flujoSalida.writeUTF("Hola Cliente " + i);
                cliente.close();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }

    /**
     * Lanzador del programa
     * @param args
     */
    public static void main(String[] args) {
        new Servidor();
    }

}
