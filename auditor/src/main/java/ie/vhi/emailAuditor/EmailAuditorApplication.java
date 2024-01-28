package ie.vhi.emailAuditor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@SpringBootApplication
public class EmailAuditorApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailAuditorApplication.class, args);
	}

}
