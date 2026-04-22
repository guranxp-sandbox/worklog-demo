package com.worklog;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/sessions")
@CrossOrigin(origins = "*")
public class SessionController {

    private final List<Session> sessions = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong();

    @PostMapping("/start")
    public Session start() {
        Session session = new Session(idCounter.incrementAndGet(), LocalDateTime.now());
        sessions.add(session);
        return session;
    }

    @GetMapping
    public List<Session> getAll() {
        return sessions;
    }
}
