import java.util.Date;

public class DateTest {
    
    public static void main(String[] args) {
        
        // Return the number of milliseconds in the Date
        // as a long, using the getTime() method
        Date d1 = new Date();
        
        // timed code goes here
        for (int i=0; i<10000000; i++) { int j = i;}
        
        Date d2 = new Date();
        
        long elapsed_time = d2.getTime() - d1.getTime();
        System.out.println("That took " + elapsed_time
                + " milliseconds");
    }
    
}
