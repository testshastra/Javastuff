import java.lang.annotation.*;

/**
 *  Annotation definition for an accessor method.  This shows the use of
 *  multiple members.
 **/
@Retention(RetentionPolicy.RUNTIME)
public @interface Accessor {
    String variableName();
    String variableType() default "String";
}