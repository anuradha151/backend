package lk.v.studms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class StudMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudMsApplication.class, args);
    }

}
