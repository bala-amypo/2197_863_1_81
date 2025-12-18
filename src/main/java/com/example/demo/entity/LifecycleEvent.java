package com.example.demo.entity;


import jakarta.persistence.*;
import java.time.*;


@Entity
public class LifecycleEvent {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


@ManyToOne(optional = false)
private Asset asset;


@Column(nullable = false)
private String eventType;


@Column(nullable = false)
private String eventDescription;


private LocalDateTime eventDate;


@ManyToOne(optional = false)
private User performedBy;


public LifecycleEvent() {}


public LifecycleEvent(Long id, Asset asset, String eventType, String eventDescription, User performedBy) {
this.id = id;
this.asset = asset;
this.eventType = eventType;
this.eventDescription = eventDescription;
this.performedBy = performedBy;
}


@PrePersist
public void prePersist() {
if (eventDate == null) eventDate = LocalDateTime.now();
}


public Long getId() { return id; }
public void setId(Long id) { this.id = id; }


public Asset getAsset() { return asset; }
public void setAsset(Asset asset) { this.asset = asset; }


public String getEventType() { return eventType; }
public void setEventType(String eventType) { this.eventType = eventType; }


public String getEventDescription() { return eventDescription; }
public void setEventDescription(String eventDescription) { this.eventDescription = eventDescription; }


public LocalDateTime getEventDate() { return eventDate; }
public void setEventDate(LocalDateTime eventDate) { this.eventDate = eventDate; }


public User getPerformedBy() { return performedBy; }
public void setPerformedBy(User performedBy) { this.performedBy = performedBy; }
}