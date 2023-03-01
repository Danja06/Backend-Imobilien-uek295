package ch.noseryoung.immobilien.core.validation.email;

import jakarta.validation.Payload;

public @interface Email {
    String message() default "not a noseryoung email";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
