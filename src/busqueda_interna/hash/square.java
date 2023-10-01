package busqueda_interna.hash;
public class square {
    public static int hashSquare(int key, int arrSize) {
        int squaredKey = key * key;
        String keyString = Integer.toString(squaredKey);

        int size = keyString.length();
        int start = (size - String.valueOf(arrSize).length()) / 2;
        int end = start + String.valueOf(arrSize).length();

        String truncatedKey = keyString.substring(start, end);
        int truncatedValue = Integer.parseInt(truncatedKey);

        return (truncatedValue % arrSize)+1;
    }

    public static void main(String[] args) {
        
    }
}
