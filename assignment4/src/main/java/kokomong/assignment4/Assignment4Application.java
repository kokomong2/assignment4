package kokomong.assignment4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Assignment4Application {

	public static void main(String[] args) {
		SpringApplication.run(Assignment4Application.class, args);
	}

}
