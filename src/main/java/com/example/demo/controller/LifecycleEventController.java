package com.example.demo.controller;

import com.example.demo.entity.LifecycleEvent;
import com.example.demo.service.LifecycleEventService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lifecycle-events")
public class LifecycleEventController {

    private final LifecycleEventService lifecycleEventService;

    public LifecycleEventController(LifecycleEventService lifecycleEventService) {
        this.lifecycleEventService = lifecycleEventService;
    }

    @PostMapping("/asset/{assetId}/user/{userId}")
    public ResponseEntity<LifecycleEvent> logEvent(
            @PathVariable Long assetId,
            @PathVariable Long userId,
            @Valid @RequestBody LifecycleEvent event) {

        return new ResponseEntity<>(
                lifecycleEventService.logEvent(assetId, userId, event),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/asset/{assetId}")
    public ResponseEntity<List<LifecycleEvent>> getEvents(@PathVariable Long assetId) {
        return ResponseEntity.ok(lifecycleEventService.getEventsForAsset(assetId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LifecycleEvent> getEvent(@PathVariable Long id) {
        return ResponseEntity.ok(lifecycleEventService.getEvent(id));
    }
}
