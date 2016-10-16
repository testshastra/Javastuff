
package maphashmap;

import java.util.HashMap;
import java.util.Map;

public class Main {
    
    private static final Integer ONE = new Integer(1);
    
    public static void main(String[] args) {
        
        // Set up testing data
        String name[] = {
            new String("Sang"),
            new String("Shin"),
            new String("Boston"),
            new String("Passion"),
            new String("Shin")
        };
        
        // Create a HashMap object
        Map m = new HashMap();
        
        // Initialize frequency table with testing data
        for (int i=0; i<name.length; i++) {
            Integer freq = (Integer) m.get(name[i]);
            
            // Adding an entry to the HashMap
            m.put(name[i], (freq==null ? ONE :
                new Integer(freq.intValue() + 1)));
        }
        
        // Display the size of the Map object
        System.out.println(m.size() + " distinct words detected:");
        
        // Display Map object
        System.out.println("Display of the HashMap object = " + m);
        
    }
    
}
