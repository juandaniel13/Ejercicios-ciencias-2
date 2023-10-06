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

    public Cubeta(int capacidad) {
        registros = new ArrayList<>(capacidad);
    }

    public void agregarRegistro(Registro registro) {
        registros.add(registro);
    }

    public List<Registro> getRegistros() {
        return registros;
    }

    public int getCantidadRegistros() {
        return registros.size();
    }
}

class TablaHash {
    private int tamano;
    private List<Cubeta> cubetas;
    private double densidadMaxima;
    private int totalRegistros;

    public TablaHash(int tamano, double densidadMaxima) {
        this.tamano = tamano;
        this.densidadMaxima = densidadMaxima;
        cubetas = new ArrayList<>(tamano);
        totalRegistros = 0;
        for (int i = 0; i < tamano; i++) {
            cubetas.add(new Cubeta(1)); // Cada cubeta inicialmente tiene capacidad para un registro
        }
    }

    public void insertarRegistro(Registro registro) {
        int indiceCubeta = calcularIndiceCubeta(registro.getClave());
        Cubeta cubeta = cubetas.get(indiceCubeta);

        if (cubeta.getCantidadRegistros() < cubeta.getRegistros().size()) {
            // La cubeta tiene espacio para más registros
            cubeta.agregarRegistro(registro);
            totalRegistros++;
        } else {
            // La cubeta está llena, se necesita expandir
            expandirTabla();
            insertarRegistro(registro); // Reintentar la inserción después de la expansión
        }

        // Verificar si se necesita reducir la tabla
        if (totalRegistros > densidadMaxima * tamano) {
            reducirTabla();
        }
    }

    private int calcularIndiceCubeta(int clave) {
        return clave % tamano;
    }

    private void expandirTabla() {
        int nuevoTamano = tamano * 2;
        List<Cubeta> nuevaTabla = new ArrayList<>(nuevoTamano);

        for (int i = 0; i < nuevoTamano; i++) {
            nuevaTabla.add(new Cubeta(1)); // Cada cubeta inicialmente tiene capacidad para un registro
        }

        // Reasignar registros a la nueva tabla
        for (Cubeta cubeta : cubetas) {
            for (Registro registro : cubeta.getRegistros()) {
                int nuevoIndice = calcularIndiceCubeta(registro.getClave(), nuevoTamano);
                nuevaTabla.get(nuevoIndice).agregarRegistro(registro);
            }
        }

        cubetas = nuevaTabla;
        tamano = nuevoTamano;
    }

    private void reducirTabla() {
        int nuevoTamano = tamano / 2;
        List<Cubeta> nuevaTabla = new ArrayList<>(nuevoTamano);

        for (int i = 0; i < nuevoTamano; i++) {
            nuevaTabla.add(new Cubeta(1)); // Cada cubeta inicialmente tiene capacidad para un registro
        }

        // Reasignar registros a la nueva tabla
        for (Cubeta cubeta : cubetas) {
            for (Registro registro : cubeta.getRegistros()) {
                int nuevoIndice = calcularIndiceCubeta(registro.getClave(), nuevoTamano);
                nuevaTabla.get(nuevoIndice).agregarRegistro(registro);
            }
        }

        cubetas = nuevaTabla;
        tamano = nuevoTamano;
    }

    private int calcularIndiceCubeta(int clave, int nuevoTamano) {
        return clave % nuevoTamano;
    }

    public void imprimirEstructura() {
        System.out.println("Tabla Hash - Tamaño: " + tamano);
        for (int i = 0; i < tamano; i++) {
            Cubeta cubeta = cubetas.get(i);
            System.out.print("Cubeta " + i + " - Registros: " + cubeta.getCantidadRegistros() + " - ");
            for (Registro registro : cubeta.getRegistros()) {
                System.out.print("(" + registro.getClave() + ", " + registro.getValor() + ") ");
            }
            System.out.println();
        }
    }
}
class HashingDinamico {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el tamaño de la tabla hash inicial: ");
        int tamanoInicial = scanner.nextInt();

        System.out.print("Ingrese la densidad de ocupación máxima para expansión válida (porcentaje): ");
        double densidadMaxima = scanner.nextDouble() / 100.0;

        TablaHash tablaHash = new TablaHash(tamanoInicial, densidadMaxima);

        while (true) {
            System.out.print("¿Desea insertar un registro? (S/N): ");
            String respuesta = scanner.next();
            if (respuesta.equalsIgnoreCase("N")) {
                break;
            }

            System.out.print("Ingrese la clave del registro: ");
            int clave = scanner.nextInt();
            System.out.print("Ingrese el valor del registro: ");
            String valor = scanner.next();

            tablaHash.insertarRegistro(new Registro(clave, valor));
            tablaHash.imprimirEstructura();
        }
    }
}
