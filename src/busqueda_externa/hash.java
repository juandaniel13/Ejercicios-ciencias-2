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
}

class TablaHash {
    private int tamano;
    private List<Cubeta> cubetas;
    private int registrosPorCubeta;
    private int metodoResolucion;

    public TablaHash(int tamano, int registrosPorCubeta, int metodoResolucion) {
        this.tamano = tamano;
        this.registrosPorCubeta = registrosPorCubeta;
        this.metodoResolucion = metodoResolucion;
        cubetas = new ArrayList<>(tamano);
        for (int i = 0; i < tamano; i++) {
            cubetas.add(new Cubeta(registrosPorCubeta));
        }
    }

    public void insertarRegistro(Registro registro) {
        int indiceCubeta = calcularIndiceCubeta(registro.getClave());

        switch (metodoResolucion) {
            case 1:
                resolverColisionDobleFuncionHash(indiceCubeta, registro);
                break;
            case 2:
                resolverColisionLineal(indiceCubeta, registro);
                break;
            case 3:
                resolverColisionEncadenamiento(indiceCubeta, registro);
                break;
            case 4:
                resolverColisionArreglosAnidados(indiceCubeta, registro);
                break;
            default:
                break;
        }
    }

    public Registro buscarRegistro(int clave) {
        int indiceCubeta = calcularIndiceCubeta(clave);

        switch (metodoResolucion) {
            case 1:
                // Implementar búsqueda por doble función hash
                break;
            case 2:
                return buscarEnCubeta(indiceCubeta, clave);
            case 3:
                return buscarEnCubetaEncadenada(indiceCubeta, clave);
            case 4:
                return buscarEnArregloAnidado(indiceCubeta, clave);
            default:
                break;
        }

        return null;
    }

    private int calcularIndiceCubeta(int clave) {
        return clave % tamano;
    }

    private void resolverColisionDobleFuncionHash(int indiceCubeta, Registro registro) {
        // Implementar resolución de colisiones por doble función hash
    }

    private void resolverColisionLineal(int indiceCubeta, Registro registro) {
        // Implementar resolución de colisiones lineal
    }

    private void resolverColisionEncadenamiento(int indiceCubeta, Registro registro) {
        Cubeta cubeta = cubetas.get(indiceCubeta);
        if (cubeta.getRegistros().size() < registrosPorCubeta) {
            cubeta.agregarRegistro(registro);
        } else {
            // Si la cubeta está llena, crea un nuevo arreglo anidado y agrega el registro allí.
            cubeta = new Cubeta(registrosPorCubeta);
            cubeta.agregarRegistro(registro);
            cubetas.add(cubeta);
        }
    }

    private Registro buscarEnCubeta(int indiceCubeta, int clave) {
        Cubeta cubeta = cubetas.get(indiceCubeta);
        for (Registro registro : cubeta.getRegistros()) {
            if (registro.getClave() == clave) {
                return registro;
            }
        }
        return null;
    }

    private Registro buscarEnCubetaEncadenada(int indiceCubeta, int clave) {
        // Implementar búsqueda en la cubeta usando encadenamiento
        return null;
    }

    private void resolverColisionArreglosAnidados(int indiceCubeta, Registro registro) {
        Cubeta cubeta = cubetas.get(indiceCubeta);
        if (cubeta.getRegistros().size() < registrosPorCubeta) {
            cubeta.agregarRegistro(registro);
        } else {
            // Si la cubeta está llena, crea un nuevo arreglo anidado y agrega el registro allí.
            cubeta = new Cubeta(registrosPorCubeta);
            cubeta.agregarRegistro(registro);
            cubetas.add(cubeta);
        }
    }

    private Registro buscarEnArregloAnidado(int indiceCubeta, int clave) {
        Cubeta cubeta = cubetas.get(indiceCubeta);
        for (Registro registro : cubeta.getRegistros()) {
            if (registro.getClave() == clave) {
                return registro;
            }
        }
        return null;
    }

    public void imprimirEstructura() {
        for (int i = 0; i < tamano; i++) {
            System.out.println("Cubeta " + i + ":");
            Cubeta cubeta = cubetas.get(i);
            for (Registro registro : cubeta.getRegistros()) {
                System.out.println("  Clave: " + registro.getClave() + ", Valor: " + registro.getValor());
            }
        }
    }
}

class BusquedaTransformacionClaves {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int tamanoTabla = solicitarTamanoTabla();
            int registrosPorCubeta = solicitarRegistrosPorCubeta();
            int metodoResolucion = seleccionarMetodoResolucion();

            TablaHash tablaHash = new TablaHash(tamanoTabla, registrosPorCubeta, metodoResolucion);

            // Solicitar al usuario ingresar registros
            solicitarInsercionRegistros(tablaHash);

            // Imprimir la estructura de datos
            tablaHash.imprimirEstructura();

            // Buscar un registro por clave
            int claveBuscada = solicitarClaveBusqueda();
            Registro registroEncontrado = tablaHash.buscarRegistro(claveBuscada);

            if (registroEncontrado != null) {
                System.out.println("Registro encontrado - Clave: " + registroEncontrado.getClave() + ", Valor: " + registroEncontrado.getValor());
            } else {
                System.out.println("Registro no encontrado para la clave: " + claveBuscada);
            }

            System.out.print("¿Desea realizar otra operación? (S/N): ");
            String respuesta = scanner.next();
            if (respuesta.equalsIgnoreCase("N")) {
                break;
            }
        }
    }

    private static int solicitarTamanoTabla() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el tamaño de la tabla hash: ");
        return scanner.nextInt();
    }

    private static int solicitarRegistrosPorCubeta() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de registros por cubeta: ");
        return scanner.nextInt();
    }

    private static int seleccionarMetodoResolucion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione un método de resolución de colisiones:");
        System.out.println("1. Doble función hash");
        System.out.println("2. Lineal");
        System.out.println("3. Encadenamiento");
        System.out.println("4. Arreglos anidados");
        System.out.print("Ingrese el número correspondiente al método: ");
        return scanner.nextInt();
    }

    private static void solicitarInsercionRegistros(TablaHash tablaHash) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese registros (clave y valor) o presione 0 para detenerse:");
        while (true) {
            System.out.print("Clave (0 para detener): ");
            int clave = scanner.nextInt();
            if (clave == 0) {
                break;
            }
            System.out.print("Valor: ");
            String valor = scanner.next();
            tablaHash.insertarRegistro(new Registro(clave, valor));
        }
    }

    private static int solicitarClaveBusqueda() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la clave que desea buscar: ");
        return scanner.nextInt();
    }
}

