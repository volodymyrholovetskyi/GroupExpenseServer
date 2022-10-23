package volodymyr.groupexpense;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class GroupExpenseServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GroupExpenseServerApplication.class, args);
    }

}
