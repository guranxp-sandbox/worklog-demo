# Worklog — Claude Code Context

## What this app is
A time-keeper app to track when work sessions start and stop.
Built as a demo of Claude Code capabilities for a mixed audience of developers and managers.

## Tech stack
- **Backend:** Java 21, Spring Boot
- **Frontend:** React + Vite
- **Storage:** In-memory (no database)
- **Target:** Runs locally on Mac mini, browser access from phone and desktop

## Repo
- GitHub: public repo named `worklog`

## Project structure
```
worklog/
  backend/    # Spring Boot app (port 8080)
  frontend/   # React + Vite app (port 5173)
```

## Demo strategy
- **Before demo:** Start button is working end-to-end (BE + FE)
- **During demo:** Add Stop button live to show Claude Code in action

## Key constraints
- Frontend must be usable on mobile browser
- Keep it simple — no auth, no database
- Cloud deployment is a future option (design with that in mind, don't over-engineer now)
