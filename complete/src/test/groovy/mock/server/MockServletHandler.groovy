package mock.server;

import org.springframework.http.HttpMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

interface MockServletHandler {

  Object call(HttpMethod httpMethod, String uri, HttpServletRequest request)

  //    Object call(HttpMethod httpMethod, String uri, HttpServletRequest request)

  Object get(String uri, Map headers)

}
