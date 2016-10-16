import java.io.*;
import java.util.*;

public class ScannerClass {
    
    public static void main(String[] args) throws IOException {
        Scanner s =
                new Scanner(new BufferedReader(new FileReader("usnumbers.txt")));
        s.useLocale(Locale.US);
        
        double sum = 0;
        
        while (s.hasNext()) {
            sum += s.nextDouble();
        }
        s.close();
        
        System.out.println("Sum of all numbers = " + sum);
    }
}


