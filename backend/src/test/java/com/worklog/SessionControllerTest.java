package com.worklog;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class SessionControllerTest {

    @Mock
    private SessionRepository repository;

    @InjectMocks
    private SessionController controller;

    @Test
    @DisplayName("Should save and return new session when start is called")
    void shouldSaveAndReturnNewSessionWhenStartIsCalled() {
        // Given
        Session saved = new Session(LocalDateTime.of(2026, 4, 22, 9, 0));
        given(repository.save(any(Session.class))).willReturn(saved);

        // When
        Session result = controller.start();

        // Then
        assertThat(result).isEqualTo(saved);
        then(repository).should().save(any(Session.class));
    }

    @Test
    @DisplayName("Should return all sessions when getAll is called")
    void shouldReturnAllSessionsWhenGetAllIsCalled() {
        // Given
        List<Session> sessions = List.of(
            new Session(LocalDateTime.of(2026, 4, 22, 8, 0)),
            new Session(LocalDateTime.of(2026, 4, 22, 10, 0))
        );
        given(repository.findAll()).willReturn(sessions);

        // When
        List<Session> result = controller.getAll();

        // Then
        assertThat(result).hasSize(2).isEqualTo(sessions);
        then(repository).should().findAll();
    }

    @Test
    @DisplayName("Should return empty list when no sessions exist")
    void shouldReturnEmptyListWhenNoSessionsExist() {
        // Given
        given(repository.findAll()).willReturn(List.of());

        // When
        List<Session> result = controller.getAll();

        // Then
        assertThat(result).isEmpty();
    }
}
