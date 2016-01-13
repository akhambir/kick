package ua.goit.controller;

import org.apache.log4j.Logger;
import ua.goit.annotation.ValidateAnnotation;
import ua.goit.dao.UserDao;
import ua.goit.model.User;
import ua.goit.service.MailServiceSending;
import ua.goit.service.MailServiceSendingImpl;
import ua.goit.service.UserService;
import ua.goit.service.UserServiceImpl;
import ua.goit.servlet.Request;
import ua.goit.validator.FormValidator;
import ua.goit.view.ModelAndView;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

@ValidateAnnotation(name = "formValidator", value = FormValidator.class)
public class SignUpController implements Controller {
  private static final Logger logger = Logger.getLogger(SignUpController.class);
  private final UserService userService;

  public SignUpController(UserService userService) {
    this.userService = userService;
  }

  @Override
  public ModelAndView handleRequest(Request request) {
    logger.info("Start execute" + SignUpController.class.getName());
    Map<String, String> parameters = request.getParameters();
    String name = parameters.get("name");
    String login = parameters.get("login");
    String password = parameters.get("password");
    String email = parameters.get("email");

    String activationKey = generateActivationKey(login, email);
    Properties properties = loadProperties();
    Enumeration propertiesNames = properties.propertyNames();

    String serverEmail = "";
    String serverPass = "";
    String domain = "";

    while (propertiesNames.hasMoreElements()) {
      switch ((String) propertiesNames.nextElement()) {
        case "email":
          serverEmail = properties.getProperty("email");
          break;
        case "password":
          serverPass = properties.getProperty("password");
          break;
        case "domain":
          domain = properties.getProperty("domain");
          break;
        default:
          break;
      }
    }

    userService.add(new User(name, login, password, email, activationKey));
    MailServiceSending mailServiceSending = new MailServiceSendingImpl(serverEmail, serverPass);
    mailServiceSending.send("Activation letter!", domain + "kickstarter/activation?key=" + activationKey, serverEmail, email);
    ModelAndView modelAndView = new ModelAndView("/confirm_registration.jsp");
    return modelAndView;
  }

  private Properties loadProperties() {
    InputStream is = getClass().getResourceAsStream("/ms.properties");
    Properties msProps = new Properties();
    try {
      msProps.load(is);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    return msProps;
  }

  private String generateActivationKey(String login, String email) {
    return new Random().nextInt(Integer.MAX_VALUE) + "";

  }
}