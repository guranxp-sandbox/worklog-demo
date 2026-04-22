package com.worklog;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime startTime;
    private LocalDateTime stopTime;

    protected Session() {}

    public Session(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public Long getId() { return id; }
    public LocalDateTime getStartTime() { return startTime; }
    public LocalDateTime getStopTime() { return stopTime; }
    public void setStopTime(LocalDateTime stopTime) { this.stopTime = stopTime; }

    public Long getDurationMinutes() {
        if (stopTime == null) return null;
        return java.time.Duration.between(startTime, stopTime).toMinutes();
    }
}
