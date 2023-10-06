package busqueda_externa;

import java.util.Arrays;

public class BinariaBloque {

    public static void busquedaBinariaBloque(Integer[] data, int clave, int bloque) {
        for (int i = 0; i < data.length; i += bloque) {
            int inicioBloque = i;
            int finBloque = Math.min(i + bloque, data.length);

            // Tratar los valores nulos en el bloque actual
            for (int j = inicioBloque; j < finBloque; j++) {
                if (data[j] == null) {
                    // Reemplaza el valor nulo con un valor que no afecte la búsqueda
                    data[j] = Integer.MIN_VALUE; // Puedes usar otros valores si es necesario
                }
            }

            // Ordenar el bloque actual antes de la búsqueda binaria
            Arrays.sort(data, inicioBloque, finBloque);

            // Realizar una búsqueda binaria en el bloque actual
            int resultado = Arrays.binarySearch(data, inicioBloque, finBloque, clave);

            if (resultado >= 0) {
                int posicionBloque = resultado - inicioBloque;
                int posicionArreglo = i + posicionBloque;
                System.out.println("Clave " + clave + " encontrada en el bloque " + (i / bloque) +
                                   ", posición en el bloque: " + posicionBloque +
                                   ", posición en el arreglo: " + posicionArreglo);
                return; // Termina la búsqueda si se encuentra la clave
            }
        }
        System.out.println("Clave " + clave + " no encontrada.");
    }
}
