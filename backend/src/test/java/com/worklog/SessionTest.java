package com.worklog;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class SessionTest {

    @Test
    @DisplayName("Should return null duration when stop time is not set")
    void shouldReturnNullDurationWhenStopTimeNotSet() {
        // Given
        Session session = new Session(LocalDateTime.now());

        // When
        Long duration = session.getDurationMinutes();

        // Then
        assertThat(duration).isNull();
    }

    @Test
    @DisplayName("Should return correct duration in minutes when stop time is set")
    void shouldReturnCorrectDurationWhenStopTimeIsSet() {
        // Given
        LocalDateTime start = LocalDateTime.of(2026, 4, 22, 9, 0);
        Session session = new Session(start);

        // When
        session.setStopTime(start.plusMinutes(90));

        // Then
        assertThat(session.getDurationMinutes()).isEqualTo(90);
    }

    @Test
    @DisplayName("Should store start time when session is created")
    void shouldStoreStartTimeWhenSessionIsCreated() {
        // Given
        LocalDateTime start = LocalDateTime.of(2026, 4, 22, 8, 30);

        // When
        Session session = new Session(start);

        // Then
        assertThat(session.getStartTime()).isEqualTo(start);
    }

    @Test
    @DisplayName("Should have null stop time when session is first created")
    void shouldHaveNullStopTimeWhenSessionIsFirstCreated() {
        // Given / When
        Session session = new Session(LocalDateTime.now());

        // Then
        assertThat(session.getStopTime()).isNull();
    }
}
