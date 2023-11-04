package trainual.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"trainual.userservice"})
@EnableJpaRepositories
public class TrainualUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainualUserServiceApplication.class, args);
	}

}
