package busqueda_externa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Registro {
    private int clave;
    private String valor;

    public Registro(int clave, String valor) {
        this.clave = clave;
        this.valor = valor;
    }

    public int getClave() {
        return clave;
    }

    public String getValor() {
        return valor;
    }
}

class Cubeta {
    private List<Registro> registros;

    public Cubeta() {
        registros = new ArrayList<>();
    }

    public void agregarRegistro(Registro registro) {
        registros.add(registro);
    }

    public List<Registro> getRegistros() {
        return registros;
    }

    public boolean estaVacia() {
        return registros.isEmpty();
    }

    public int getCantidadRegistros() {
        return registros.size();
    }

    public void eliminarRegistro(int indice) {
        registros.remove(indice);
    }
}

class TablaHash {
    private List<Cubeta> cubetas;
    private int tamaño;
    private double densidadOcupaciónMaxima;
    private double densidadOcupaciónMinima;

    public TablaHash(int tamañoMinimo, int tamañoMaximo, double densidadOcupaciónMaxima, double densidadOcupaciónMinima) {
        this.tamaño = tamañoMinimo;
        this.densidadOcupaciónMaxima = densidadOcupaciónMaxima;
        this.densidadOcupaciónMinima = densidadOcupaciónMinima;
        cubetas = new ArrayList<>(tamañoMinimo);
        for (int i = 0; i < tamañoMinimo; i++) {
            cubetas.add(new Cubeta());
        }
    }

    public void insertarRegistro(Registro registro) {
        int indiceCubeta = calcularIndiceCubeta(registro.getClave());

        Cubeta cubeta = cubetas.get(indiceCubeta);
        cubeta.agregarRegistro(registro);

        // Verificar la densidad de ocupación y expandir si es necesario
        if (calcularDensidadOcupación() > densidadOcupaciónMaxima) {
            expandirTabla();
        }
    }

    public void eliminarRegistro(int clave) {
        int indiceCubeta = calcularIndiceCubeta(clave);

        Cubeta cubeta = cubetas.get(indiceCubeta);
        List<Registro> registros = cubeta.getRegistros();
        for (int i = 0; i < registros.size(); i++) {
            if (registros.get(i).getClave() == clave) {
                cubeta.eliminarRegistro(i);
                break;
            }
        }

        // Verificar la densidad de ocupación y reducir parcialmente si es necesario
        if (calcularDensidadOcupación() < densidadOcupaciónMinima && tamaño > 1) {
            reducirTabla();
        }
    }

    public void imprimirEstructura() {
        for (int i = 0; i < tamaño; i++) {
            Cubeta cubeta = cubetas.get(i);
            System.out.println("Cubeta " + i + ":");
            if (!cubeta.estaVacia()) {
                List<Registro> registros = cubeta.getRegistros();
                for (Registro registro : registros) {
                    System.out.println("  Clave: " + registro.getClave() + ", Valor: " + registro.getValor());
                }
            }
        }
    }

    private int calcularIndiceCubeta(int clave) {
        return clave % tamaño;
    }

    private double calcularDensidadOcupación() {
        int registrosTotales = 0;
        for (Cubeta cubeta : cubetas) {
            registrosTotales += cubeta.getCantidadRegistros();
        }
        return (double) registrosTotales / tamaño;
    }

    private void expandirTabla() {
        int nuevoTamaño = tamaño * 2;
        List<Cubeta> nuevaTabla = new ArrayList<>(nuevoTamaño);

        for (int i = 0; i < nuevoTamaño; i++) {
            nuevaTabla.add(new Cubeta());
        }

        for (Cubeta cubeta : cubetas) {
            List<Registro> registros = cubeta.getRegistros();
            for (Registro registro : registros) {
                int nuevoIndice = registro.getClave() % nuevoTamaño;
                nuevaTabla.get(nuevoIndice).agregarRegistro(registro);
            }
        }

        cubetas = nuevaTabla;
        tamaño = nuevoTamaño;
    }

    private void reducirTabla() {
        int nuevoTamaño = tamaño / 2;
        List<Cubeta> nuevaTabla = new ArrayList<>(nuevoTamaño);

        for (int i = 0; i < nuevoTamaño; i++) {
            nuevaTabla.add(new Cubeta());
        }

        for (Cubeta cubeta : cubetas) {
            List<Registro> registros = cubeta.getRegistros();
            for (Registro registro : registros) {
                int nuevoIndice = registro.getClave() % nuevoTamaño;
                nuevaTabla.get(nuevoIndice).agregarRegistro(registro);
            }
        }

        cubetas = nuevaTabla;
        tamaño = nuevoTamaño;
    }
}

 class HashingDinamico {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el tamaño mínimo de la tabla hash: ");
        int tamañoMinimo = scanner.nextInt();

        System.out.print("Ingrese el tamaño máximo de la tabla hash: ");
        int tamañoMaximo = scanner.nextInt();

        System.out.print("Ingrese la densidad de ocupación máxima para expansión válida (porcentaje): ");
        double densidad
    }
}