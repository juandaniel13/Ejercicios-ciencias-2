package busqueda_externa;

public class Externa {
    private int[] data; // Estructura para almacenar los registros
    private int blockSize; // Tamaño del bloque

    public Externa(int maxSize) {
        this.data = new int[maxSize];
        this.blockSize = (int) Math.sqrt(maxSize); // Tamaño del bloque es la raíz cuadrada del número total de registros
    }

    // Método para realizar una búsqueda secuencial en bloques de registros
    public boolean busquedaSecuencial(int clave) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == clave) {
                return true; // Se encontró la clave en el bloque actual
            }
            // Si llegamos al final del bloque o al final de los registros, detenemos la búsqueda
            if ((i + 1) % blockSize == 0 || i == data.length - 1) {
                break;
            }
        }
        return false; // No se encontró la clave
    }

    // Método para realizar una búsqueda binaria en bloques de registros
    public boolean busquedaBinaria(int clave) {
        for (int i = 0; i < data.length; i += blockSize) {
            int start = i;
            int end = Math.min(i + blockSize - 1, data.length - 1);

            // Realizamos la búsqueda binaria en el bloque actual
            int result = Arrays.binarySearch(data, start, end + 1, clave);

            if (result >= 0) {
                return true; // Se encontró la clave en el bloque actual
            }
        }
        return false; // No se encontró la clave
    }

    // Método para agregar un registro
    public void agregarRegistro(int registro) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == 0) {
                data[i] = registro;
                break;
            }
        }
    }  
}
