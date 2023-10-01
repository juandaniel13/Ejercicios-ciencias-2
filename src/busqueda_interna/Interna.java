package busqueda_interna;

import java.util.Arrays;
import java.util.Scanner;

public class Interna {
    private Integer[] data = new Integer[100];


    public Interna(Integer[] data){
        this.data = data;
    }

     public Integer[] getData() {
        return data;
    }

    
    public void ingrearClave(int clave, int posicion){
        data[posicion] = clave;
    }

    public void llenarEstructura(){
    
        int i = 0;
        Scanner input = new Scanner(System.in);
        while (i < data.length) {
            System.out.println("ingresa la clave en la posición: " + (i + 1));
            int clave = input.nextInt();
            System.out.println("presiona 0 para dejar de ingresar claves");

            if(clave == 0){
                break;
            }
            if (!Arrays.asList(data).contains(clave)) {

                ingrearClave(clave, i);
                i++;
                //System.out.println(Arrays.toString(busquInterna.getData()));
            } else {
                System.out.println(
                        "La clave que intenta ingresar ya se encuentra dentro de la estructura de datos, vuelva a intentar");
            }

        }
       
    }

    public void buscarClave(int clave, String metodo){
        if(metodo == "secuencial"){
            secuencial.busquedaSecuncial(data, clave);
        }
    }

}
