# Worklog

A simple time-keeper app to track work sessions — when they start and stop.

Built as a demo of [Claude Code](https://claude.ai/code) capabilities.

## Tech stack

- **Backend:** Java 21, Spring Boot (port 8080)
- **Frontend:** React + Vite (port 5173)
- **Storage:** H2 in-memory database (via JPA)

## Getting started

### Backend

```bash
cd backend
./mvnw spring-boot:run
```

### Frontend

```bash
cd frontend
npm install
npm run dev
```

Then open [http://localhost:5173](http://localhost:5173) in your browser.

## Usage

- Press **Start Work** to begin a session.
- Sessions are listed below the button with their start time.
- Stop functionality coming soon.

## Notes

- No authentication — designed for local use on a trusted network.
- Data resets on server restart (in-memory H2 database).
- Mobile-friendly UI.
