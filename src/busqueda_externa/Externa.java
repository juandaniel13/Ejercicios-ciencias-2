package busqueda_externa;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;

class HashingDinamico {

    private List<List<Integer>> cubetas;
    private int tamanoInicial;
    private int tamanoActual;
    private double densidadOcupacion;

    public HashingDinamico(int tamanoInicial, double densidadOcupacion) {
        this.tamanoInicial = tamanoInicial;
        this.tamanoActual = tamanoInicial;
        this.densidadOcupacion = densidadOcupacion;

        this.cubetas = new ArrayList<>();

        for (int i = 0; i < tamanoInicial; i++) {
            cubetas.add(new ArrayList<>());
        }
    }

    public void insertar(Integer elemento) {
        if (getFactorCarga() > densidadOcupacion) {
            expandir();
        }

        int cubeta = getCubeta(elemento);

        cubetas.get(cubeta).add(elemento);
        tamanoActual++;

        imprimirEstructuraDatos();
    }

    public void eliminar(Integer elemento) {
        int cubeta = getCubeta(elemento);

        cubetas.get(cubeta).remove(elemento);
        tamanoActual--;

        if (getFactorCarga() < (densidadOcupacion / 2)) {
            reducir();
        }

        imprimirEstructuraDatos();
    }

    private void expandir() {
        int nuevoTamano = tamanoActual * 2;
        List<List<Integer>> nuevasCubetas = new ArrayList<>();

        for (int i = 0; i < nuevoTamano; i++) {
            nuevasCubetas.add(new ArrayList<>());
        }

        for (List<Integer> cubeta : cubetas) {
            for (Integer elemento : cubeta) {
                int nuevaCubeta = elemento % nuevoTamano;
                nuevasCubetas.get(nuevaCubeta).add(elemento);
            }
        }

        this.cubetas = nuevasCubetas;
        this.tamanoActual = nuevoTamano;
    }

    private void reducir() {
        int nuevoTamano = tamanoActual / 2;
        List<List<Integer>> nuevasCubetas = new ArrayList<>();

        for (int i = 0; i < nuevoTamano; i++) {
            nuevasCubetas.add(new ArrayList<>());
        }

        for (List<Integer> cubeta : cubetas) {
            for (Integer elemento : cubeta) {
                int nuevaCubeta = elemento % nuevoTamano;
                nuevasCubetas.get(nuevaCubeta).add(elemento);
            }
        }

        this.cubetas = nuevasCubetas;
        this.tamanoActual = nuevoTamano;
    }

    private int getCubeta(Integer elemento) {
        return elemento % tamanoActual;
    }

    private double getFactorCarga() {
        return (double) tamanoActual / (double) tamanoInicial;
    }

    private void imprimirEstructuraDatos {
        System.out.println("---------- Estructura de Datos ----------");
        for (int i = 0; i < tamanoActual; i++) {
            System.out.print("Cubeta " + i + ": ");
            for (Integer elemento : cubetas.get(i)) {
                System.out.print(elemento + " ");
            }
            System.out.println();
        }
        System.out.println("-----------------------------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        int tamanoInicial = 5;
        double densidadOcupacion = 0.75;

        HashingDinamico hashingDinamico = new HashingDinamico(tamanoInicial, densidadOcupacion);

        hashingDinamico.insertar(7);
        hashingDinamico.insertar(3);
        hashingDinamico.insertar(10);
        hashingDinamico.insertar(21);
        hashingDinamico.insertar(15);

        hashingDinamico.eliminar(3);
        hashingDinamico.eliminar(15);
    }
}
