package ua.goit.validator;

import ua.goit.servlet.Request;

import java.util.Map;

public class FormValidator extends AbstractValidator {
    @Override
    public boolean validate(Request request) {
        Map<String, String> parameters = request.getParameters();
        String name = parameters.get("name");
        String login = parameters.get("login");
        String password = parameters.get("password");
        String repeat_password = parameters.get("repeat_password");
        String email = parameters.get("email");

        //validation should be here)

        return true;
    }
}
