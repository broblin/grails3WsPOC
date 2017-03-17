import org.apache.camel.component.servlet.CamelHttpTransportServlet
import org.springframework.boot.web.servlet.ServletRegistrationBean

// Place your Spring DSL code here
beans = {
    servletRegistrationBean(ServletRegistrationBean){
        servlet = new CamelHttpTransportServlet()
        name="CamelServlet"
        urlMappings = ["/camel-demo/*"]
    }
}