
package clientechat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JTextField;
import org.apache.log4j.Logger;

/**
 * Esta clase gestiona el envio de datos entre el cliente y el servidor.
 * 
 * @author Ivan Salas Corrales <http://programando-o-intentandolo.blogspot.com.es/>
 */
public class ConexionServidor implements ActionListener {
    
    private Logger log = Logger.getLogger(ConexionServidor.class);
    private Socket socket; 
    private JTextField tfMensaje;
    private String usuario;
    private volatile DataOutputStream salidaDatos;
    
    public ConexionServidor(Socket socket, JTextField tfMensaje, String usuario) {
        this.socket = socket;
        this.tfMensaje = tfMensaje;
        this.usuario = usuario;
        // No creamos el stream aquí para evitar NPEs si el socket es nulo.
        // Se creará perezosamente en el primer envío.
    }

    public boolean isConnected() {
        return this.socket != null && !this.socket.isClosed();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!isConnected()) {
            log.error("No conectado al servidor. Mensaje no enviado.");
            return;
        }

        if (salidaDatos == null) {
            synchronized (this) {
                if (salidaDatos == null) {
                    try {
                        salidaDatos = new DataOutputStream(socket.getOutputStream());
                    } catch (IOException ex) {
                        log.error("Error al crear el stream de salida : " + ex.getMessage());
                    } catch (NullPointerException ex) {
                        log.error("El socket no se creo correctamente. ");
                    }
                }
            }
        }

        if (salidaDatos == null) {
            log.error("No se pudo establecer el stream de salida. Mensaje no enviado.");
            return;
        }

        try {
            salidaDatos.writeUTF(usuario + ": " + tfMensaje.getText());
            tfMensaje.setText("");
        } catch (IOException ex) {
            log.error("Error al intentar enviar un mensaje: " + ex.getMessage());
        }
    }

}