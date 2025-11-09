package practice.springboot.features.springboot_practice.repo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import practice.springboot.features.springboot_practice.entity.AppUser;


public interface UserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByUsername(String username);
}