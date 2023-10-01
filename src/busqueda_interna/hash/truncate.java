package hash;
public class truncate {
        public static int truncate(Integer key1, int arrLength) {
            String key = Integer.toString(key1);
            int truncateLength = 3; 
            
            truncateLength = Math.min(truncateLength, key.length());
    
            
            String truncatedKey = key.substring(0, truncateLength);
    
            
            int hashValue = Integer.parseInt(truncatedKey);
    
           
            return (hashValue % arrLength)+1;
        }
    
        public static void main(String[] args) {
        
        }
    
    
}
