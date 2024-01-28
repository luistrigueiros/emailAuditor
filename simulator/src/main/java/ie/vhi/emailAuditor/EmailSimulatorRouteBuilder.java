package ie.vhi.emailAuditor;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EmailSimulatorRouteBuilder extends RouteBuilder {
    @Value("${simulator.inputEndpoint}")
    private String inputEndpoint;
    @Value("${simulator.outputEndpoint}")
    private String outputEndpoint;

    @Override
    public void configure() throws Exception {
        log.info("Will consume from {}", inputEndpoint);
        log.info("Will send to {} ", outputEndpoint);

        from(inputEndpoint)
                .id("EMAIL_SIMULATOR_ROUTE")
                .log("Got email ${body}")
                .to(outputEndpoint);
    }
}
