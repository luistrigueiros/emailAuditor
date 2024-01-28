package ie.vhi.emailAuditor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@SpringBootApplication
public class EmailSimulatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailSimulatorApplication.class, args);
	}

}
