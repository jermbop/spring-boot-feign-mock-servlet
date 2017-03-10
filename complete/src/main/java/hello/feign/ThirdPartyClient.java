package hello.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@FeignClient(name="thirdparty", url = "http://localhost:8081", decode404 = true)
@RequestMapping(value = "/thirdparty", produces = APPLICATION_JSON_UTF8_VALUE)
public interface ThirdPartyClient {

  @RequestMapping(value = "/{requestParam}", method = GET)
  @ResponseBody
  String findByRequestParam(@PathVariable("requestParam") final String requestParams);
}
