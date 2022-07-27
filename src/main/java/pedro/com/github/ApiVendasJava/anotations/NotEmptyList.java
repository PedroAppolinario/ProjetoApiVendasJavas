package pedro.com.github.ApiVendasJava.anotations;



import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotEmptyListValidator.class)
public @interface NotEmptyList {

    String message() default "A lista não pode ser vazia";

    //Receita de Bolo (copia e cola)
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
