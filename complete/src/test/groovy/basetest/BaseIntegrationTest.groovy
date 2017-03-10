package basetest

import hello.Application
import mock.server.MockServletHandler
import mock.server.MockTomcatServer
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Shared
import spock.lang.Specification

@ContextConfiguration
@SpringBootTest(classes = Application.class, webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
class BaseIntegrationTest extends Specification {

    @Shared
    MockTomcatServer mockTomcatServer

    MockServletHandler mockServletHandler

    def setupSpec() {
        mockTomcatServer = new MockTomcatServer()
        mockTomcatServer.startTomcat()
    }

    def setup() {
        mockServletHandler = Mock(MockServletHandler)
        mockTomcatServer.setMockServletHandler(mockServletHandler)
    }

    def cleanupSpec() {
        mockTomcatServer.stopTomcat()
    }

}
