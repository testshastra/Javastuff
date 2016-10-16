import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
public @interface Reviewer {
    Name value();
}