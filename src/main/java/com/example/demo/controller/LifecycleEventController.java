package com.example.demo.controller;

import com.example.demo.entity.LifecycleEvent;
import com.example.demo.service.LifecycleEventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lifecycle-events")
public class LifecycleEventController {

    private final LifecycleEventService lifecycleEventService;

    public LifecycleEventController(LifecycleEventService lifecycleEventService) {
        this.lifecycleEventService = lifecycleEventService;
    }

    @PostMapping("/{assetId}")
    public LifecycleEvent create(@PathVariable Long assetId,
                                 @RequestBody LifecycleEvent event) {
        return lifecycleEventService.createLifecycleEvent(assetId, event);
    }

    @GetMapping
    public List<LifecycleEvent> getAll() {
        return lifecycleEventService.getAllLifecycleEvents();
    }

    @GetMapping("/{id}")
    public LifecycleEvent getById(@PathVariable Long id) {
        return lifecycleEventService.getLifecycleEventById(id);
    }
}
