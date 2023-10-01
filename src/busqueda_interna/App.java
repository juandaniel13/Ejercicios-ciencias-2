package busqueda_interna;

import java.util.Arrays;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Integer[] data = new Integer[100];
        Integer[] dataHash = new Integer[100];
        Interna busquInterna = new Interna(data, dataHash);

        // iniciar programa
        boolean salir = false;
        int opcion = 0;
        Scanner input = new Scanner(System.in);
        while (salir == false) {

            //SECUNCIAL Y BINARIO
            System.out.println(
                    "selecciona una opción: \n 1. llenar estructura \n 2. Imprimir estructura \n 3. Buscar clave \n" + //
                            " 4. Transformación de claves (hash) ");
            opcion = input.nextInt();
            if (opcion == 1) {
                busquInterna.llenarEstructura();
            }
            if (opcion == 2) {
                System.out.println(Arrays.toString(busquInterna.getData()));
            }
            if (opcion == 3) {
                System.out.println("ingresa la clave que deseas buscar");
                int clave = input.nextInt();
                busquInterna.buscarClave(clave, "secuencial");
            }
            //TRASNFORMACIÓN DE CLAVES
            if (opcion == 4) {
                System.out.println("selecciona una opción: \n 1. mod \n 2. folding, \n 3. square \n  4. truncate ");
                int opcionHas = input.nextInt();
                if (opcionHas == 1) {
                    System.out.println(
                            "selecciona una opción: \n 1. llenar estructura \n 2. Imprimir estructura \n 3. Buscar clave \n");
                    int opcionMod = input.nextInt();
                    if (opcionMod == 1) {
                        busquInterna.llenarEstructuraHash("mod");
                    }
                    if (opcionMod == 2) {
                        System.out.println(Arrays.toString(busquInterna.getDataHash()));
                    }
                    if (opcionMod == 3) {
                        System.out.println("ingresa la clave que deseas buscar");
                        int clave = input.nextInt();
                        busquInterna.buscarClaveHash(clave, "mod");
                    }
                }
                if (opcionHas == 2) {
                    System.out.println(
                            "selecciona una opción: \n 1. llenar estructura \n 2. Imprimir estructura \n 3. Buscar clave \n");
                    int opcionMod = input.nextInt();
                    if (opcionMod == 1) {
                        busquInterna.llenarEstructuraHash("folding");
                    }
                    if (opcionMod == 2) {
                        System.out.println(Arrays.toString(busquInterna.getDataHash()));
                    }
                    if (opcionMod == 3) {
                        System.out.println("ingresa la clave que deseas buscar");
                        int clave = input.nextInt();
                        busquInterna.buscarClaveHash(clave, "folding");
                    }
                }
                if (opcionHas == 3) {
                    System.out.println(
                            "selecciona una opción: \n 1. llenar estructura \n 2. Imprimir estructura \n 3. Buscar clave \n");
                    int opcionMod = input.nextInt();
                    if (opcionMod == 1) {
                        busquInterna.llenarEstructuraHash("square");
                    }
                    if (opcionMod == 2) {
                        System.out.println(Arrays.toString(busquInterna.getDataHash()));
                    }
                    if (opcionMod == 3) {
                        System.out.println("ingresa la clave que deseas buscar");
                        int clave = input.nextInt();
                        busquInterna.buscarClaveHash(clave, "square");
                    }
                }
                if (opcionHas == 4) {
                    System.out.println(
                            "selecciona una opción: \n 1. llenar estructura \n 2. Imprimir estructura \n 3. Buscar clave \n");
                    int opcionMod = input.nextInt();
                    if (opcionMod == 1) {
                        busquInterna.llenarEstructuraHash("truncate");
                    }
                    if (opcionMod == 2) {
                        System.out.println(Arrays.toString(busquInterna.getDataHash()));
                    }
                    if (opcionMod == 3) {
                        System.out.println("ingresa la clave que deseas buscar");
                        int clave = input.nextInt();
                        busquInterna.buscarClaveHash(clave, "truncate");
                    }
                }
            }
        }
    }

}
