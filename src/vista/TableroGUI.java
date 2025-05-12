package vista;

import controlador.TableroControlador;
import modelo.Tablero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que representa la interfaz gráfica del tablero
 */
public class TableroGUI extends JFrame {
    private JButton[][] casillas;
    private JPanel panelTablero;
    private JButton btnNuevo;
    private JLabel statusLabel;
    private TableroControlador controlador;

    /**
     * Constructor de la interfaz gráfica
     * @param controlador Controlador del tablero
     */
    public TableroGUI(TableroControlador controlador) {
        this.controlador = controlador;

        // Configuración de la ventana
        setTitle("Problema de las 8 Reinas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Crear componentes
        crearComponentes();

        // Configurar el layout
        configurarLayout();

        pack();
        setLocationRelativeTo(null);
    }

    /**
     * Crea los componentes de la interfaz gráfica
     */
    private void crearComponentes() {
        int tamano = Tablero.getTAMANO();

        // Panel del tablero
        panelTablero = new JPanel(new GridLayout(tamano, tamano));
        casillas = new JButton[tamano][tamano];

        // Crear casillas del tablero
        for (int i = 0; i < tamano; i++) {
            for (int j = 0; j < tamano; j++) {
                casillas[i][j] = new JButton();
                casillas[i][j].setPreferredSize(new Dimension(60, 60));

                // Alternar colores de las casillas
                if ((i + j) % 2 == 0) {
                    casillas[i][j].setBackground(Color.WHITE);
                } else {
                    casillas[i][j].setBackground(Color.LIGHT_GRAY);
                }

                // Agregar acción al botón
                final int fila = i;
                final int columna = j;
                casillas[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        controlador.celdaSeleccionada(fila, columna);
                    }
                });

                panelTablero.add(casillas[i][j]);
            }
        }

        // Botón de nuevo juego
        btnNuevo = new JButton("Nueva Partida");
        btnNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.nuevoJuego();
            }
        });

        // Etiqueta de estado
        statusLabel = new JLabel("Seleccione una casilla para colocar la primera reina");
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
    }

    /**
     * Configura el layout de la interfaz gráfica
     */
    private void configurarLayout() {
        setLayout(new BorderLayout());

        add(panelTablero, BorderLayout.CENTER);
        add(btnNuevo, BorderLayout.SOUTH);
        add(statusLabel, BorderLayout.NORTH);
    }

    /**
     * Actualiza la vista del tablero
     * @param tablero Modelo del tablero
     */
    public void actualizarVista(Tablero tablero) {
        int tamano = Tablero.getTAMANO();

        for (int i = 0; i < tamano; i++) {
            for (int j = 0; j < tamano; j++) {
                // Alternar colores de las casillas
                if ((i + j) % 2 == 0) {
                    casillas[i][j].setBackground(Color.WHITE);
                } else {
                    casillas[i][j].setBackground(Color.LIGHT_GRAY);
                }

                // Mostrar reina si hay una en la casilla
                if (tablero.hayReina(i, j)) {
                    casillas[i][j].setText("♕");
                    casillas[i][j].setFont(new Font("Arial", Font.BOLD, 24));
                } else {
                    casillas[i][j].setText("");
                }
            }
        }
    }

    /**
     * Muestra un mensaje en la etiqueta de estado
     * @param mensaje Mensaje a mostrar
     */
    public void mostrarMensaje(String mensaje) {
        statusLabel.setText(mensaje);
    }

    /**
     * Muestra un mensaje de diálogo
     * @param mensaje Mensaje a mostrar
     * @param titulo Título del diálogo
     * @param tipo Tipo de diálogo
     */
    public void mostrarDialogo(String mensaje, String titulo, int tipo) {
        JOptionPane.showMessageDialog(this, mensaje, titulo, tipo);
    }
}