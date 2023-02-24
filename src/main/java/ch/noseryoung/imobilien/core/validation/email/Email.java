package ch.noseryoung.imobilien.core.validation.email;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
@Constraint(validatedBy = EmailValidator.class)
public @interface Email {
    String message() default "not a noseryoung email";
    Class<?>[] groups() default {};
    Class<? Payload>[] payload() default {};
}
