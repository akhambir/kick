package ua.goit.servlet;

import java.util.HashMap;
import java.util.Map;

public class Request {
  private final String method;
  private final String url;
  private Map<String, String> parameters;

  public Request(Map<String, String[]> param, Method method, String url) {
    this.method = method.toString();
    this.url = url;
    this.parameters = setParam(param);
  }

  public Request(Map<String, String[]> param, String method, String url) {
    this.method = method.toUpperCase();
    this.url = url;
    this.parameters = setParam(param);
  }

  public static Request create(Method method, String url) {
    return new Request(null, method, url);
  }

  public Map<String, String> getParameters() {
    return parameters;
  }

  public String getUrl() {
    return url;
  }

  public String getMethod() {
    return method;
  }

  @Override
  public int hashCode() {
    int result = method.hashCode();
    return 31 * result + url.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Request request = (Request) obj;
    if (!method.equals(request.getMethod())) return false;
    if (!url.equals(request.getUrl())) return false;
    return true;
  }

  @Override
  public String toString() {
    return super.toString();
  }

  private Map<String, String> setParam(Map<String, String[]> param) {
    Map<String, String> parameters = new HashMap<>();
    if (param != null) {
      for (String paramName : param.keySet()) {
        String[] paramValues = param.get(paramName);
        System.out.println(paramName + " " + paramValues[0]);
        parameters.put(paramName, paramValues[0]);
      }
    }
    return parameters;
  }
}
