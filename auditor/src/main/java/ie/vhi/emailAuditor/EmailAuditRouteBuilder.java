package ie.vhi.emailAuditor;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EmailAuditRouteBuilder extends RouteBuilder {
    @Value("${inputEndpoint}")
    private String inputEndpoint;

    @Autowired
    private EmailAuditRepository emailAuditRepository;

    @Override
    public void configure() throws Exception {
        log.info("Will consume from {}", inputEndpoint);
        from(inputEndpoint)
                .id("EMAIL_AUDIT_ROUTE")
                .log("Got email ${body}")
                .process(this::storeEmailAudit);
    }

   private void storeEmailAudit(Exchange exchange) {
        Email email = exchange.getIn().getBody(Email.class);
        EmailAudit emailAudit = EmailAudit.buildFrom(email);
        emailAuditRepository.save(emailAudit);
        log.info("Saved audit {}", emailAudit);
   }

}
