import hash.mod;
import hash.square;
import hash.truncate;
import hash.folding;

public class App {

    static int[] keys = {
            1234, 5678, 2345, 6789, 4321,
            8765, 3455, 7890, 6543, 9476,
            5432, 8901, 6779, 2109, 1111,
            3456, 7654, 9876, 8977, 45009

    };

    static int[] hashKeys = new int[100];

    public static int hash(int key, String method, int arrLength) {
        int hashKey = 0;
        switch (method) {
            case "mod":
                hashKey = mod.mod(key, arrLength);
                break;
            case "square":
                hashKey = square.hashSquare(key, arrLength);
                break;
            case "truncate":
                hashKey = truncate.truncate(Integer.toString(key), arrLength);
                break;
            case "folding":
                hashKey = folding.folding(Integer.toString(key), arrLength);
                break;

            default:
                break;

        }
        return hashKey;

    }

    public static void insertHashKeys(String method, int arrLength) {
        int i = 0;
        int direction;
        while (i < keys.length - 1) {
            direction = hash(keys[i], method, hashKeys.length);
            if (hashKeys[direction] != 0) {
                System.out.println("Se ha presentado una colisión, la clave " + hashKeys[direction]
                        + " está ocupando la posición " + direction + " que la calve " + keys[i] + " pretende ocupar");
                i++;
            } else {
                hashKeys[direction] = keys[i];
                System.out.println("Elemento en la posición " + direction + ": " + keys[i]);
                i++;
            }

        }

    }

    public static void searchHashKey(int key, int arrLength, String methood) {
       int direction = hash(key, methood, arrLength);
        if (hashKeys[direction] == 0) {
            System.out.println("La clave no se encontró en la estructura de datos");
        } else {
            System.out.println("el elemento "+key+" se econtró en la posición "+direction+ " de la estructura de datos");
        }
    }

    public static void main(String[] args) throws Exception {
       //MÉTODOS ->  mod square truncate folding
        insertHashKeys("folding", 100);
        System.out.println("///////////////////////////////////////////////////////////////////////");
        searchHashKey(1234,100,"folding");
    }
}
