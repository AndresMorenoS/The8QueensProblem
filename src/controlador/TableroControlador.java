package controlador;

import modelo.Tablero;
import vista.TableroGUI;
import javax.swing.JOptionPane;

/**
 * Clase controlador que maneja la lógica entre el modelo y la vista
 */
public class TableroControlador {
    private Tablero modelo;
    private TableroGUI vista;
    private boolean primeraReina;

    /**
     * Constructor del controlador
     * @param modelo Modelo del tablero
     */
    public TableroControlador(Tablero modelo) {
        this.modelo = modelo;
        this.primeraReina = true;
    }

    /**
     * Establece la vista
     * @param vista Vista del tablero
     */
    public void setVista(TableroGUI vista) {
        this.vista = vista;
    }

    /**
     * Maneja la selección de una celda por parte del usuario
     * @param fila Fila seleccionada
     * @param columna Columna seleccionada
     */
    public void celdaSeleccionada(int fila, int columna) {
        if (primeraReina) {
            // Limpiar el tablero antes de colocar la primera reina
            modelo.limpiarTablero();

            // Intentar resolver el problema con la reina inicial en la posición seleccionada
            boolean resuelto = modelo.resolverConReinaInicial(fila, columna);

            // Actualizar la vista
            vista.actualizarVista(modelo);

            if (resuelto) {
                vista.mostrarMensaje("¡Problema resuelto con éxito!");
                vista.mostrarDialogo("Se ha encontrado una solución colocando la primera reina en la posición (" + (fila+1) + "," + (columna+1) + ")", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                vista.mostrarMensaje("No se puede resolver el problema desde esa posición");
                vista.mostrarDialogo("No se puede resolver el problema colocando la primera reina en la posición (" + (fila+1) + "," + (columna+1) + ")", "Error", JOptionPane.ERROR_MESSAGE);
            }

            primeraReina = false;
        }
    }

    /**
     * Inicia un nuevo juego
     */
    public void nuevoJuego() {
        modelo.limpiarTablero();
        vista.actualizarVista(modelo);
        vista.mostrarMensaje("Seleccione una casilla para colocar la primera reina");
        primeraReina = true;
    }

    /**
     * Inicia el juego
     */
    public void iniciarJuego() {
        vista.setVisible(true);
    }
}