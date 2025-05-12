package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa el tablero de ajedrez y la lógica del problema
 */
public class Tablero {
    private static final int TAMANO = 8;
    private List<Reina> reinas;
    private boolean[][] tablero;

    /**
     * Constructor del tablero
     */
    public Tablero() {
        this.reinas = new ArrayList<>();
        this.tablero = new boolean[TAMANO][TAMANO];

        // Inicializar tablero vacío
        for (int i = 0; i < TAMANO; i++) {
            for (int j = 0; j < TAMANO; j++) {
                tablero[i][j] = false;
            }
        }
    }

    /**
     * Limpia el tablero y elimina todas las reinas
     */
    public void limpiarTablero() {
        reinas.clear();
        for (int i = 0; i < TAMANO; i++) {
            for (int j = 0; j < TAMANO; j++) {
                tablero[i][j] = false;
            }
        }
    }

    /**
     * Coloca una reina en una posición específica
     * @param fila Fila donde colocar la reina
     * @param columna Columna donde colocar la reina
     * @return true si se pudo colocar la reina, false en caso contrario
     */
    public boolean colocarReina(int fila, int columna) {
        // Verificar que la posición esté dentro del tablero
        if (fila < 0 || fila >= TAMANO || columna < 0 || columna >= TAMANO) {
            return false;
        }

        // Verificar que no haya una reina en la posición
        if (tablero[fila][columna]) {
            return false;
        }

        // Crear una nueva reina
        Reina nuevaReina = new Reina(fila, columna);

        // Verificar que no amenace a otras reinas
        for (Reina reina : reinas) {
            if (nuevaReina.amenaza(reina)) {
                return false;
            }
        }

        // Colocar la reina
        reinas.add(nuevaReina);
        tablero[fila][columna] = true;

        return true;
    }

    /**
     * Elimina la reina de una posición específica
     * @param fila Fila de la reina a eliminar
     * @param columna Columna de la reina a eliminar
     */
    public void eliminarReina(int fila, int columna) {
        reinas.removeIf(reina -> reina.getFila() == fila && reina.getColumna() == columna);
        tablero[fila][columna] = false;
    }

    /**
     * Resuelve el problema de las 8 reinas utilizando backtracking
     * @return true si se encontró una solución, false en caso contrario
     */
    public boolean resolver() {
        // Si ya hay 8 reinas, el problema está resuelto
        if (reinas.size() == TAMANO) {
            return true;
        }

        // Si hay al menos una reina, empezar desde la columna 0
        int columnaInicio = 0;

        // Intentar colocar reinas en cada fila
        for (int fila = 0; fila < TAMANO; fila++) {
            for (int columna = columnaInicio; columna < TAMANO; columna++) {
                if (colocarReina(fila, columna)) {
                    // Si se colocó la reina, intentar resolver el resto del tablero
                    if (resolver()) {
                        return true;
                    }

                    // Si no se pudo resolver, eliminar la reina y continuar
                    eliminarReina(fila, columna);
                }
            }
        }

        // No se encontró solución
        return false;
    }

    /**
     * Resuelve el problema de las 8 reinas con una reina inicial colocada
     * @param filaInicial Fila de la reina inicial
     * @param columnaInicial Columna de la reina inicial
     * @return true si se encontró una solución, false en caso contrario
     */
    public boolean resolverConReinaInicial(int filaInicial, int columnaInicial) {
        limpiarTablero();

        // Colocar la reina inicial
        if (!colocarReina(filaInicial, columnaInicial)) {
            return false;
        }

        return resolverBacktracking(0);
    }

    /**
     * Método auxiliar para resolver el problema utilizando backtracking
     * @param fila Fila actual a evaluar
     * @return true si se encontró una solución, false en caso contrario
     */
    private boolean resolverBacktracking(int fila) {
        // Si ya hay 8 reinas, el problema está resuelto
        if (reinas.size() == TAMANO) {
            return true;
        }

        // Intentar colocar reinas en cada fila
        for (int f = fila; f < TAMANO; f++) {
            for (int c = 0; c < TAMANO; c++) {
                if (colocarReina(f, c)) {
                    // Si se colocó la reina, intentar resolver el resto del tablero
                    if (resolverBacktracking(f + 1)) {
                        return true;
                    }

                    // Si no se pudo resolver, eliminar la reina y continuar
                    eliminarReina(f, c);
                }
            }
        }

        // No se encontró solución
        return false;
    }

    /**
     * Verifica si hay una reina en una posición específica
     * @param fila Fila a verificar
     * @param columna Columna a verificar
     * @return true si hay una reina, false en caso contrario
     */
    public boolean hayReina(int fila, int columna) {
        return tablero[fila][columna];
    }

    /**
     * Obtiene el tamaño del tablero
     * @return Tamaño del tablero
     */
    public static int getTAMANO() {
        return TAMANO;
    }

    /**
     * Obtiene la lista de reinas
     * @return Lista de reinas
     */
    public List<Reina> getReinas() {
        return reinas;
    }
}
