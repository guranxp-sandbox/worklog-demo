package com.worklog;

import java.time.LocalDateTime;

public class Session {
    private final long id;
    private final LocalDateTime startTime;
    private LocalDateTime stopTime;

    public Session(long id, LocalDateTime startTime) {
        this.id = id;
        this.startTime = startTime;
    }

    public long getId() { return id; }
    public LocalDateTime getStartTime() { return startTime; }
    public LocalDateTime getStopTime() { return stopTime; }
    public void setStopTime(LocalDateTime stopTime) { this.stopTime = stopTime; }

    public Long getDurationMinutes() {
        if (stopTime == null) return null;
        return java.time.Duration.between(startTime, stopTime).toMinutes();
    }
}
