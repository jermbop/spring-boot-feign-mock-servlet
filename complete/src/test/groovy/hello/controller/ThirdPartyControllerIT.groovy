package hello.controller

import basetest.BaseIntegrationTest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.embedded.LocalServerPort
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate

import javax.servlet.http.HttpServletRequest

import static org.springframework.http.HttpMethod.GET

class ThirdPartyControllerIT extends BaseIntegrationTest {

  @LocalServerPort port

  @Autowired
  RestTemplate restTemplate

  def "controller third party call - respond with 200 and response body"() {

    when:
    ResponseEntity<String> response = this.restTemplate.getForEntity(URI.create("http://localhost:${port}/foobar/myrequestparam"), String.class)

    then:
    1 * this.mockServletHandler.call(GET, "/thirdparty/myrequestparam", _ as HttpServletRequest) >> "hello world"
    response.getBody() == "hello world"
  }

  def "controller third party call - third party throws 404, no FeignException"() {

    when:
    ResponseEntity<String> response = this.restTemplate.getForEntity(URI.create("http://localhost:${port}/foobar/myrequestparam"), String.class)

    then:
    1 * this.mockServletHandler.call(GET, "/thirdparty/myrequestparam", _ as HttpServletRequest) >> 404
  }

}
