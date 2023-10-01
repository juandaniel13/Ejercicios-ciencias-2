package busqueda_interna;
import java.util.Arrays;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
     
        Integer[] data = new Integer[100];
        Interna busquInterna = new Interna(data);

      /*   busquInterna.llenarEstructura();
        busquInterna.buscarClave(45, "secuencial"); */
        
        //iniciar programa
        boolean salir = false;
        int opción = 0;
        Scanner input = new Scanner(System.in);
        while(salir == false){
            System.out.println("selecciona una opción: \n 1. llenar eestructura \n 2. Imprimir estructura \n 3. Buscar clave");
            opción = input.nextInt();
            if(opción == 1){
                busquInterna.llenarEstructura();
            }
            if(opción == 2){
                System.out.println(Arrays.toString(busquInterna.getData()));
            }
            if (opción == 3) {
                System.out.println("ingresa la clave que deseas buscar");
                int clave = input.nextInt();
                busquInterna.buscarClave(clave, "secuencial");
            }
        }
    }

}
