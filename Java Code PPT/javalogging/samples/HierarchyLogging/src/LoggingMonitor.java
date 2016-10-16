
import java.util.logging.*;

class ParentLogger{
    private Logger logger = Logger.getLogger("sam.logging");
    private Level level = null;
    
    public ParentLogger(){
        level = Level.SEVERE;
        //setting the level as SEVERE
        logger.setLevel(level);
    }
    
    public void aMethod() {
        logger.log(level, "Severe message from Parent Logger");
    }
}

class ChildLogger{
    private Logger logger = Logger.getLogger("sam.logging.child");
    
    private Level level = null;
    public ChildLogger() {
        //level = Level.INFO;
        //setting the level of this child logger, if not specified, it
        // will use the level of the parent logger
        logger.setLevel(level);
    }
    
    public void aMethod() {
        logger.log(Level.INFO, "Info message from Child Logger");
        logger.log(Level.SEVERE, "Severe message from Child Logger");
    }
}


public class LoggingMonitor {
    public static void main(String[] args){
        ParentLogger pLogger = new ParentLogger();
        ChildLogger cLogger = new ChildLogger();
        cLogger.aMethod();
    }
}