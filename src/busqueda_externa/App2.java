package busqueda_externa;

import java.util.Arrays;
import java.util.Scanner;

public class App2 {
    public static void main(String[] args) {
        Integer[] data = new Integer[100];
        Integer[] dataHash = new Integer[100];
        Externa busquedaExterna = new Externa(data, dataHash);
        // iniciar programa
        boolean salir = false;
        int opcion = 0;
        Scanner input = new Scanner(System.in);
        while (!salir) {
            System.out.println(
                    "Selecciona una opción:\n 1. Llenar estructura\n 2. Imprimir estructura\n 3. Buscar clave\n" +
                            " 4. Transformación de claves (hash)\n 5. Salir");
            opcion = input.nextInt();

            switch (opcion) {
                case 1:
                    busquedaExterna.llenarEstructura();
                    break;
                case 2:
                    System.out.println(Arrays.toString(busquedaExterna.getData()));
                    break;
                case 3:
                    System.out.println(
                            "Ingresa el método por el cual deseas buscar:\n 1. Búsqueda secuencial\n 2. Búsqueda binaria");
                    int opcionBusqueda = input.nextInt();
                    if (opcionBusqueda == 1) {
                        System.out.println("Ingresa la clave que deseas buscar: ");
                        int clave = input.nextInt();
                        busquedaExterna.buscarClave(clave, "secuencial");
                    }
                    if (opcionBusqueda == 2) {
                        System.out.println("Ingresa la clave que deseas buscar: ");
                        int clave = input.nextInt();
                        busquedaExterna.buscarClave(clave, "binaria");
                    }
                    break;
                case 4:
                    // Agrega la lógica para la transformación de claves (hash) aquí
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }
        }
    }
}
