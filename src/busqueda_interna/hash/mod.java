package busqueda_interna.hash;
public class mod {
    public static int mod(int key,int arrSize){
    
         /* System.out.println(newKey);  */
    
        return (key%arrSize)+1;
    }
    public static void main(String[] args) {
      System.out.println(mod(1999923,100));
    }
}
