package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "lifecycle_events")
public class LifecycleEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Asset is required")
    @ManyToOne
    @JoinColumn(name = "asset_id", nullable = false)
    private Asset asset;

    @NotBlank(message = "Event type is required")
    @Column(nullable = false)
    private String eventType;

    @NotBlank(message = "Event description is required")
    @Column(nullable = false)
    private String eventDescription;

    private LocalDateTime eventDate;

    @NotNull(message = "Performed by user is required")
    @ManyToOne
    @JoinColumn(name = "performed_by", nullable = false)
    private User performedBy;

    public LifecycleEvent() {
    }

    public LifecycleEvent(Long id, Asset asset, String eventType,
                          String eventDescription, LocalDateTime eventDate,
                          User performedBy) {
        this.id = id;
        this.asset = asset;
        this.eventType = eventType;
        this.eventDescription = eventDescription;
        this.eventDate = eventDate;
        this.performedBy = performedBy;
    }

    @PrePersist
    public void prePersist() {
        if (this.eventDate == null) {
            this.eventDate = LocalDateTime.now();
        }
    }

    public Long getId() {
        return id;
    }

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventType() {
        return eventType;
    }
 
    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventDescription() {
        return eventDescription;
    }
 
    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public LocalDateTime getEventDate() {
        return eventDate;
    }
 
    public void setEventDate(LocalDateTime eventDate) {
        this.eventDate = eventDate;
    }

    public User getPerformedBy() {
        return performedBy;
    }
 
    public void setPerformedBy(User performedBy) {
        this.performedBy = performedBy;
    }
}
