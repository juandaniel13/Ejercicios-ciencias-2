package busqueda_interna;

import java.util.Arrays;
import java.util.Scanner;

import busqueda_interna.hash.folding;
import busqueda_interna.hash.mod;
import busqueda_interna.hash.truncate;
import busqueda_interna.hash.square;

public class Interna {
    private Integer[] data = new Integer[100];
    private Integer[] dataHash = new Integer[100];

    /*
     * public Interna(Integer[] data){
     * this.data = data;
     * }
     */
    public Interna(Integer[] data, Integer[] dataHash) {
        this.data = data;
        this.dataHash = dataHash;
    }

    //gettes
    public Integer[] getData() {
        return data;
    }

    public Integer[] getDataHash() {
        return dataHash;
    }

    //metodos secuencial y binario
    public void ingrearClave(int clave, int posicion, Integer[] estructura) {
        estructura[posicion] = clave;
    }

    public void llenarEstructura() {

        int i = 0;
        Scanner input = new Scanner(System.in);
        while (i < data.length) {
            System.out.println("ingresa la clave en la posición: " + (i + 1));
            int clave = input.nextInt();
            System.out.println("presiona 0 para dejar de ingresar claves");

            if (clave == 0) {
                break;
            }
            if (!Arrays.asList(data).contains(clave)) {

                ingrearClave(clave, i, data);
                i++;
                // System.out.println(Arrays.toString(busquInterna.getData()));
            } else {
                System.out.println(
                        "La clave que intenta ingresar ya se encuentra dentro de la estructura de datos, vuelva a intentar");
            }

        }

    }

    public void buscarClave(int clave, String metodo) {
        if (metodo == "secuencial") {
            secuencial.busquedaSecuncial(data, clave);
        }
        if (metodo == "binaria") {
            Binaria.busquedaBinaria(data, clave);
        }
    }


    //metodos hash
    public void llenarEstructuraHash(String metodo) {
        int i = 0;
        Scanner input = new Scanner(System.in);
        while (i < dataHash.length) {
            System.out.println("Digite la clave que desea ingresar:");
            int clave = input.nextInt();
    
            if (clave == 0) {
                break;
            }
            if (!Arrays.asList(dataHash).contains(clave)) {
                Integer direccion;
                if ("mod".equals(metodo)) {
                    direccion = mod.mod(clave, dataHash.length);
                } else if ("square".equals(metodo)) {
                    direccion = folding.folding(clave, dataHash.length);
                } else if ("truncate".equals(metodo)) {
                    direccion = truncate.truncate(clave, dataHash.length);
                } else if ("folding".equals(metodo)) {
                    direccion = folding.folding(clave, dataHash.length);
                } else {
                    System.out.println("Método de hash no válido.");
                    continue; // Salta al siguiente ciclo si el método no es válido
                }
    
                ingrearClave(clave, direccion, dataHash);
                System.out.println("La clave se ha ingresado en la posición: " + direccion);
                i++;
            } else {
                System.out.println("La clave que intenta ingresar ya se encuentra dentro de la estructura de datos, vuelva a intentar");
            }
        }
    }

    public void buscarClaveHash(int clave, String metodo) {
        int resultado = Arrays.asList(dataHash).indexOf(clave);
        if (resultado != -1) {
            System.out.println("La clave buscada se encuentra en la posición: " + resultado);
        } else {
            System.out.println("La clave buscada NO se encuentra en la estructura de datos");
        }
    }

}
