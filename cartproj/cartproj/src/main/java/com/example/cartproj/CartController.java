package com.example.cartproj;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
@RestController
@RequestMapping("/cart")
public class CartController {
    private final List<CartItem> items = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();
    // Get all items
    @GetMapping
    public List<CartItem> getAllItems() {
        return items;
    }
    // Create new user
    @PostMapping
    public ResponseEntity<CartItem> createUser(@RequestBody CartItem item) {
        item.setId(counter.incrementAndGet());
        items.add(item);
        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }
    // Delete user
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteitem(@PathVariable Long id) {
        Optional<CartItem> userOptional = items.stream().filter(u -> u.getId().equals(id)).findFirst();
        if (userOptional.isPresent()) {
            items.remove(userOptional.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
