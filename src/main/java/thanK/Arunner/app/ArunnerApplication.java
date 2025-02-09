package thanK.Arunner.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("thanK.Arunner")
public class ArunnerApplication {

    private static final Logger log = LoggerFactory.getLogger(ArunnerApplication.class);

    public static void main(String[] args) {
	SpringApplication.run(ArunnerApplication.class, args);
    }

//    @Bean
//    CommandLineRunner runner(RunRepository repository) {
//	return args -> {
//	    Run runs = new Run(1, "FirstRun", LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS), 5,
//		    Location.OUTDOOR);
//	    repository.createRun(runs);
//
//	};
//    }

}
