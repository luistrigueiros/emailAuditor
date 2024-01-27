package ie.vhi.emailAuditor;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EmailAuditRouteBuilder extends RouteBuilder {
    @Value("${inputEndpoint}")
    private String inputEndpoint;
    @Override
    public void configure() throws Exception {
        from(inputEndpoint)
                .id("EMAIL_AUDIT_ROUTE")
                .log("Got email ${body}");
    }
}
