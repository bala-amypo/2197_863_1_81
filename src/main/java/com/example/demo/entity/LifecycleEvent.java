package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "lifecycle_events")
public class LifecycleEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "asset_id")
    private Asset asset;

    private String eventType;

    private String eventDescription;

    private LocalDateTime eventDate;

    @ManyToOne
    @JoinColumn(name = "performed_by")
    private User performedBy;

    @PrePersist
    public void prePersist() {
        if (this.eventDate == null) {
            this.eventDate = LocalDateTime.now();
        }
    }

    // No-arg constructor
    public LifecycleEvent() {
    }

    // Parameterized constructor
    public LifecycleEvent(Long id, Asset asset, String eventType,
                          String eventDescription,
                          LocalDateTime eventDate, User performedBy) {
        this.id = id;
        this.asset = asset;
        this.eventType = eventType;
        this.eventDescription = eventDescription;
        this.eventDate = eventDate;
        this.performedBy = performedBy;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    public String getEventType() {
        return eventType;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    // public User getPerformedBy() {
    //     return performedBy;
    // }
    public User getPerformedBy() {
    return performedBy;
}

public void setPerformedBy(User performedBy) {
    this.performedBy = performedBy;
}
}
