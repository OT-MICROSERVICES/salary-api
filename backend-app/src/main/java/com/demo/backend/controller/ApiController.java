package com.demo.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.Instant;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/health")
    public ResponseEntity<Map<String, Object>> health() {
        return ResponseEntity.ok(Map.of(
            "status",    "UP",
            "service",   "backend-app",
            "timestamp", Instant.now().toString()
        ));
    }

    @GetMapping("/items")
    public ResponseEntity<Map<String, Object>> items() {
        return ResponseEntity.ok(Map.of(
            "items", new String[]{"Apple", "Banana", "Cherry"},
            "count", 3
        ));
    }

    @PostMapping("/echo")
    public ResponseEntity<Map<String, Object>> echo(@RequestBody Map<String, Object> body) {
        return ResponseEntity.ok(Map.of(
            "echoed",    body,
            "timestamp", Instant.now().toString()
        ));
    }
}
