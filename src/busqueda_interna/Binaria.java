package busqueda_interna;

/**
 * Binaria
 */
public class Binaria {

    public static int busquedaBinaria(Integer[] arreglo, int clave) {
        int izquierda = 0;
        int derecha = arreglo.length - 1;
    
        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
    
            if (arreglo[medio] != null && arreglo[medio] == clave) {
                System.out.println("Clave encontrada en la posición: " + medio);
                return medio; // La clave ha sido encontrada en la posición "medio"
            } else if (arreglo[medio] != null && arreglo[medio] < clave) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }
    
        System.out.println("Clave no encontrada en el arreglo.");
        return -1; // La clave no se encontró en el arreglo
    }
}