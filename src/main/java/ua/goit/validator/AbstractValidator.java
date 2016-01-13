package ua.goit.validator;

import ua.goit.servlet.Request;

public abstract class AbstractValidator {
    public abstract boolean validate(Request request);
}
