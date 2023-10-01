package busqueda_interna.hash;
public class folding {
    public static int folding(int clave1, int arrLength) {
        String clave = Integer.toString(clave1);
        int segmentSize = 2; // Tamaño de cada segmento
        int sum = 0;

        // Dividir la clave en segmentos y sumar los valores de los segmentos
        for (int i = 0; i < clave.length(); i += segmentSize) {
            String segment = clave.substring(i, Math.min(i + segmentSize, clave.length()));
            sum += Integer.parseInt(segment);
        }

        // Calcular el valor hash como la suma de los segmentos
        int hashValue = sum;

        // Aplicar la operación de módulo para obtener un índice válido dentro del arreglo
        return (hashValue % arrLength)+1;
    }

    public static void main(String[] args) {
    
    }

}
