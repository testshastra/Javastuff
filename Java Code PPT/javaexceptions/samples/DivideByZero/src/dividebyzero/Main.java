
package dividebyzero;

public class Main {
    
    /** Creates a new instance of Main */
    public Main() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            System.out.println(3/0);
        } catch(ArithmeticException e){
            System.out.printf("Caught runtime exception = %s", e);
        }
    }
    
}
