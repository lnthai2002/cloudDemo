package cloud.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JmsqApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(JmsqApplication.class, args);
	}
}
