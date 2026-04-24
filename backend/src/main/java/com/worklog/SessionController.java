package com.worklog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/sessions")
@CrossOrigin(origins = "*")
public class SessionController {

    private static final Logger log = LoggerFactory.getLogger(SessionController.class);

    private final SessionRepository repository;

    public SessionController(SessionRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/start")
    public Session start() {
        log.info("Start button pressed — creating new session");
        return repository.save(new Session(LocalDateTime.now()));
    }

    @PostMapping("/{id}/stop")
    public Session stop(@PathVariable Long id) {
        log.info("Stop button pressed for session {}", id);
        return repository.findById(id)
                .map(session -> {
                    session.setStopTime(LocalDateTime.now());
                    return repository.save(session);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Session not found"));
    }

    @GetMapping
    public List<Session> getAll() {
        log.info("Fetching all sessions");
        return repository.findAll();
    }
}
