# Worklog — Implementation Plan

## Phase 1: Initial commit (before demo)
Goal: Start button working end-to-end.

### Backend
- `POST /api/sessions/start` — starts a session, returns session with start time
- `GET /api/sessions` — returns all sessions with start time, stop time, duration
- In-memory storage using a list

### Frontend
- Single page with a **Start Work** button
- On click: calls `POST /api/sessions/start`
- Below button: table showing past sessions (start time, stop time, duration)
- Mobile-friendly layout

---

## Phase 2: Live during demo
Goal: Add Stop button in front of the audience using Claude Code.

### Backend
- `POST /api/sessions/stop` — stops the active session, records stop time

### Frontend
- **Stop Work** button appears when a session is active
- Table updates to show completed session with duration

---

## Future (post-demo)
- Cloud deployment (Railway, Fly.io, or similar)
- Persistent storage (PostgreSQL)
- Summary endpoint: total time worked today
