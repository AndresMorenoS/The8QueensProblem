

import controlador.TableroControlador;
import modelo.Tablero;
import vista.TableroGUI;

import javax.swing.*;

/**
 * Clase principal de la aplicación
 */
public class AplicacionOchoReinas {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Crear el modelo
                Tablero modelo = new Tablero();

                // Crear el controlador
                TableroControlador controlador = new TableroControlador(modelo);

                // Crear la vista
                TableroGUI vista = new TableroGUI(controlador);

                // Establecer la vista en el controlador
                controlador.setVista(vista);

                // Iniciar el juego
                controlador.iniciarJuego();
            }
        });
    }
}