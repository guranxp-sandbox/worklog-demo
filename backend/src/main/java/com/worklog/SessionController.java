package com.worklog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public List<Session> getAll() {
        return repository.findAll();
    }
}
