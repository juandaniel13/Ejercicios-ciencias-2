public class secuencial {

    public static void main(String[] args) {
       int x=2; //valor que quiero buscar
       Integer busqueda = null;
            int lista[] = {1,2,3,4,5,6};
            for (int i=0; i<lista.length; i++){
                if(x==lista[i]){
                busqueda = i;
            
         }
    }
            if(busqueda!=null){
                 System.out.println("El elemento "+x+" se encuentra en la posición "+busqueda+" de la lista");
            }else System.out.println("Elemento no encontrado");
}
}