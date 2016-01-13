package ua.goit.view;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.Map;

public class ModelAndView {
  private Map<String, Object> attributes = new HashMap<>();
  private String view;
  private boolean hasCookie = false;
  private Cookie cookie;

  public ModelAndView(String view) {
    this.view = view;
  }

  public boolean isHasCookie() {
    return hasCookie;
  }

  public void setHasCookie(boolean hasCookie) {
    this.hasCookie = hasCookie;
  }

  public Map<String, Object> getAttributes() {
    return attributes;
  }

  public void setAttributes(Map<String, Object> attributes) {
    this.attributes = attributes;
  }

  public void addAttribute(String name, Object attribute) {
    attributes.put(name, attribute);
  }

  public Object getAttribute(String name) {
    return attributes.get(name);
  }

  public Cookie getCookie() {
    return cookie;
  }

  public void setCookie(String name, String taken) {
    cookie = new Cookie(name, taken);
  }

  public String getView() {
    return view;
  }

  public void setView(String view) {
    this.view = view;
  }


}
