package ch.noseryoung.imobilien.core.validation.email;

public @interface Email {
    String message() default "not a noseryoung email";
    Class<?>[] groups() default {};
    Class<? Payload>[] payload() default {};
}
