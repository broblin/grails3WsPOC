package camelpoc

import grails.test.mixin.integration.Integration
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import spock.lang.Specification

/**
 * Created by broblin on 21/03/17.
 */
@Integration
class JolokiaSpec extends Specification {


    def "access to Jolokia"() {
        when:
        def entity = new TestRestTemplate().getForEntity("http://localhost:8080/jolokia/read/java.lang:type=Memory", String)

        then:
        entity.statusCode == HttpStatus.OK
        and:
        def body = entity.body
        body.contains('"HeapMemoryUsage":')
    }
}
