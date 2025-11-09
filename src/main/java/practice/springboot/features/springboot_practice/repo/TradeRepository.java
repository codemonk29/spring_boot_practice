package practice.springboot.features.springboot_practice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.springboot.features.springboot_practice.entity.Trade;


public interface TradeRepository extends JpaRepository<Trade, Long> {}