package camelpoc.builder

import camelpoc.dataformat.ToStringDataFormat
import camelpoc.dto.Partner
import com.fasterxml.jackson.databind.SerializationFeature
import org.apache.camel.builder.RouteBuilder
import org.apache.camel.component.file.FileEndpoint
import org.apache.camel.component.jackson.JacksonDataFormat
import org.springframework.beans.factory.annotation.Value

/**
 * Created by broblin on 06/03/17.
 */
class PartnerRouteBuilderService extends RouteBuilder {

    static transactional = false

    @Value(value ="\${partner.port}" )
    String partnerWsPort

    @Value(value ="\${partner.resource}" )
    String partnerPath

    private String inputDirectory="/opt/test/migration/partner";

    private String outputDirectory="/opt/test/migration/partner/success";

    @Override
    public void configure() throws Exception {

        ToStringDataFormat toStringDataFormat = new ToStringDataFormat()
        JacksonDataFormat jdf=new JacksonDataFormat(Partner)
        jdf.setDisableFeatures(SerializationFeature.FAIL_ON_EMPTY_BEANS.name())


        from("rest:get:hello").routeId("get-hello")
                .transform().constant("Bye World")


        FileEndpoint inFileEndpoint = new FileEndpoint();
        inFileEndpoint.setCamelContext(getContext());
        inFileEndpoint.setFile(new File(inputDirectory));

        inFileEndpoint.setPreMove("working/\${date:now:yyyyMMdd}/\${file:name}");
        inFileEndpoint.setMove("archive/\${date:now:yyyyMMdd}/\${file:name}-\${date:now:yyyyMMddhhmmsss}.completed");
        inFileEndpoint.setDelay(1000);
        inFileEndpoint.setKeepLastModified(true);
        inFileEndpoint.setAutoCreate(true);
        inFileEndpoint.setFilter{file ->
            return file.getFileName().contains("json");
        };

        FileEndpoint outFileEndpoint = new FileEndpoint();
        outFileEndpoint.setCamelContext(getContext());
        outFileEndpoint.setFile(new File(outputDirectory));
        outFileEndpoint.setFileName("\${file:name.noext}.txt");
        outFileEndpoint.setAutoCreate(true);



        from(inFileEndpoint).routeId("partner-json-file")
                .unmarshal(jdf)
                .marshal(toStringDataFormat)
                .to(outFileEndpoint)
        ;
    }



}
