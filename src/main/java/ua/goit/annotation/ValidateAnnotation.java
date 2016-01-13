package ua.goit.annotation;

import ua.goit.validator.AbstractValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)

public @interface ValidateAnnotation {
     String name();
     Class<? extends AbstractValidator> value();
}
