import java.util.Date;
import java.text.MessageFormat;
import java.util.*;

public class UsingVarArgs {
    public UsingVarArgs() { }

    public String formatThis() {

        return( MessageFormat.format( "On {2}, a {0} destroyed {1} houses and caused {3} of damage",
                                                      "Hurricane",
                                                      new Integer( 99 ),
                                                      new GregorianCalendar( 1999, 0, 1).getTime(),
                                                      new Double( 10E7 ) ) );
    }

    public static void main( String[] args ) {

        UsingVarArgs v = new UsingVarArgs();
        System.out.println( v.formatThis());

    }
}