package practice.springboot.features.springboot_practice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import practice.springboot.features.springboot_practice.entity.AppUser;
import practice.springboot.features.springboot_practice.repo.UserRepository;

@SpringBootApplication
public class TradeSecurityDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TradeSecurityDemoApplication.class, args);
    }

    @Bean
    CommandLineRunner init(UserRepository userRepo, PasswordEncoder encoder) {
        return args -> {
            if (userRepo.findByUsername("admin").isEmpty()) {
                AppUser admin = new AppUser();
                admin.setUsername("admin");
                admin.setPassword(encoder.encode("adminpass"));
                admin.setRole("ROLE_ADMIN");
                userRepo.save(admin);
            }
            if (userRepo.findByUsername("user").isEmpty()) {
                AppUser user = new AppUser();
                user.setUsername("user");
                user.setPassword(encoder.encode("userpass"));
                user.setRole("ROLE_USER");
                userRepo.save(user);
            }
        };
    }
}
