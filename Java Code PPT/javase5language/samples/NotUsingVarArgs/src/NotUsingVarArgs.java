import java.util.Date;
import java.text.MessageFormat;
import java.util.*;

public class NotUsingVarArgs {
    
    public String formatThis() {
        
        Object[] args = {
            "Hurricane",
            new Integer( 99 ),
            new GregorianCalendar( 1999, 0, 1).getTime(),
            new Double( 10E7 )     };
        
        return MessageFormat.format( "On {2}, a {0} destroyed {1} houses and caused {3} of damage",
                args );
    }
    
    public static void main( String[] args ) {
        
        NotUsingVarArgs v = new NotUsingVarArgs();
        System.out.println( v.formatThis());
        
    }
}