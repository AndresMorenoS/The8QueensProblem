
package modelo;
/**
 * Clase que representa una reina en el tablero de ajedrez
 */
public class Reina {
    private int fila;
    private int columna;

    /**
     * Constructor de la reina
     * @param fila Fila donde se colocará la reina
     * @param columna Columna donde se colocará la reina
     */
    public Reina(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    /**
     * Verifica si esta reina amenaza a otra reina
     * @param otraReina La otra reina a verificar
     * @return true si hay amenaza, false en caso contrario
     */
    public boolean amenaza(Reina otraReina) {
        // Misma fila
        if (this.fila == otraReina.fila) {
            return true;
        }

        // Misma columna
        if (this.columna == otraReina.columna) {
            return true;
        }

        // Misma diagonal
        if (Math.abs(this.fila - otraReina.fila) == Math.abs(this.columna - otraReina.columna)) {
            return true;
        }

        return false;
    }

    // Getters y setters
    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
}
