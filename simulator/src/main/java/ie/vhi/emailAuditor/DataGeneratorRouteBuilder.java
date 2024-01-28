package ie.vhi.emailAuditor;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DataGeneratorRouteBuilder extends RouteBuilder {
    @Value("${simulator.dataGeneratorInputEndpoint}")
    private String dataGeneratorInputEndpoint;

    @Value("${simulator.inputEndpoint}")
    private String emailSimulatorInputEndpoint;

    @Override
    public void configure() throws Exception {
        log.info("Will consume from {}", dataGeneratorInputEndpoint);
        log.info("Will send to {} ", emailSimulatorInputEndpoint);
        from(dataGeneratorInputEndpoint)
                .process( exchange -> {
                    exchange.getIn().setBody(generateMockData());
                })
                .log("Got send ${body}")
                .to(emailSimulatorInputEndpoint);
    }

    private Email generateMockData() {
        return EmailImpl.builder()
                .toAddress("toAddress")
                .fromAddress("fromAddress")
                .subject("subject")
                .content("content")
                .build();
    }
}
