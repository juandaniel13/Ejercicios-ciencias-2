package busqueda_externa;

import java.sql.Array;
import java.util.Arrays;

public class SecuencialBloque{
    public static void busquedaSecuncialBloque(Integer[] data, int clave, int bloque) {
        for (int i = 0; i < data.length; i += bloque) {
            int inicioBloque = i;
            int finBloque = Math.min(i + bloque, data.length);
            
            for (int j = finBloque - 1; j >= inicioBloque; j--) {
                if (data[j] != null && data[j] == clave) {
                    int posicionBloque = j - inicioBloque;
                    int posicionArreglo = i + posicionBloque;
                    
                    System.out.println("Clave " + clave + " encontrada en el bloque " + (i / bloque) +
                                       ", posición en el bloque: " + posicionBloque +
                                       ", posición en el arreglo: " + posicionArreglo);
                    return; // Termina la búsqueda si se encuentra la clave
                }
            }
        }
        System.out.println("Clave " + clave + " no encontrada.");
    }
}