# Worklog — Demo Script

## Setup (before audience arrives)
- Mac mini running, backend and frontend both started
- App open in browser on screen
- Phone browser also open to the app

## Act 1: Show the working app (2-3 min)
1. Open the app in the browser
2. Click **Start Work** — show the session appearing in the table
3. Explain: "This was built with Claude Code. Let me show you how we add a feature live."

## Act 2: Add Stop button live with Claude Code (5-7 min)
Tell Claude Code:
> "Add a Stop Work button that calls POST /api/sessions/stop and updates the session list"

Show the audience:
- Claude Code reads the existing code
- Writes the backend endpoint
- Updates the React frontend
- App reloads — Stop button appears and works

## Key talking points
- No boilerplate written by hand
- Claude Code understands the full codebase context
- Developer stays in control — reviews and approves changes
- Same workflow scales to complex features
