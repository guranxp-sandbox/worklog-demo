package com.worklog;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/sessions")
@CrossOrigin(origins = "*")
public class SessionController {

    private final SessionRepository repository;

    public SessionController(SessionRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/start")
    public Session start() {
        return repository.save(new Session(LocalDateTime.now()));
    }

    @GetMapping
    public List<Session> getAll() {
        return repository.findAll();
    }
}
