package ua.goit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import ua.goit.service.*;

public class UserFilter implements Filter {
  private final UserService userService;
  private String token = "user";

  public UserFilter(UserService userService) {
    this.userService = userService;
  }

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) request;
    Cookie[] cookies = req.getCookies();
    String tokenValue = null;
    /*for (Cookie c : cookies) {
      if (token.equals(c.getName())) {
        tokenValue = c.getValue();
        User user = userService.findByToken(tokenValue);
        req.setAttribute("userID", user.getId());
      }
    }*/
    chain.doFilter(req, response);
  }

  @Override
  public void destroy() {

  }
}