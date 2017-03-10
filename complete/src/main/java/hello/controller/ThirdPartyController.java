package hello.controller;

import hello.feign.ThirdPartyClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ThirdPartyController {

  @Autowired
  private ThirdPartyClient thirdPartyClient;

  @RequestMapping("/foobar/{requestParam}")
  @ResponseBody
  public String foobarRequest(@PathVariable String requestParam) {
    String byRequestParam = thirdPartyClient.findByRequestParam(requestParam);
    return byRequestParam;
  }
}
