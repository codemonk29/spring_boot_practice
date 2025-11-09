package practice.springboot.features.springboot_practice.controller;

import org.springframework.web.bind.annotation.*;
import practice.springboot.features.springboot_practice.entity.Trade;
import practice.springboot.features.springboot_practice.repo.TradeRepository;

import java.util.List;

@RestController
@RequestMapping("/api/trades")
public class TradeController {

    private final TradeRepository repo;

    public TradeController(TradeRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Trade> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public Trade create(@RequestBody Trade trade) {
        return repo.save(trade);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
