package fr.shcherbakov.countservice;

import fr.shcherbakov.countservice.entities.Account;
import fr.shcherbakov.countservice.entities.enums.AccountType;
import fr.shcherbakov.countservice.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.properties")
@EnableAspectJAutoProxy
public class CountServiceApplication {
//      example os SpEl
//      @Value("#{ new Boolean(environment['spring.profiles.active'] != 'prod') }")
//      private boolean isProd;

    public static void main(String[] args) {
        SpringApplication.run(CountServiceApplication.class, args);
    }

    @Bean
    @Profile("!prod")
    public CommandLineRunner startH2(AccountRepository h2Repository) {
        return (args) -> {
            h2Repository.save(new Account(1L, "David Bowie", 150_000D, AccountType.COURANT));
            h2Repository.save(new Account(2L, "Mike Gouberstain", 110_000D, AccountType.EPARGNE));
            h2Repository.save(new Account(3L, "Milly CocoRosie", 520_000D, AccountType.COURANT));
        };
    }
}
