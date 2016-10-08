package art.data.hackaton;

import static org.springframework.boot.SpringApplication.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.annotation.PreDestroy;

@SpringBootApplication(scanBasePackages = "art.data.hackaton")
public class ArtDataHackatonApplication {

    private static ConfigurableApplicationContext context;

    public static void main(String[] args) {
        context = run(ArtDataHackatonApplication.class, args);
    }

    @PreDestroy
    public void shutDown() {
        SpringApplication.exit(context, () -> 0);
    }
}
