import { useState, useEffect } from 'react'
import './App.css'

const API = `${import.meta.env.VITE_API_URL ?? ''}/api/sessions`

function formatTime(iso) {
  if (!iso) return '—'
  return new Date(iso).toLocaleTimeString()
}

export default function App() {
  const [sessions, setSessions] = useState([])

  const fetchSessions = () =>
    fetch(API).then(r => r.json()).then(setSessions)

  useEffect(() => { fetchSessions() }, [])

  const handleStart = () =>
    fetch(`${API}/start`, { method: 'POST' })
      .then(fetchSessions)

  return (
    <div className="app">
      <h1>Worklog</h1>

      <button className="btn-start" onClick={handleStart}>
        Start Work
      </button>

      <table>
        <thead>
          <tr>
            <th>#</th>
            <th>Started</th>
            <th>Stopped</th>
            <th>Duration (min)</th>
          </tr>
        </thead>
        <tbody>
          {sessions.length === 0 && (
            <tr><td colSpan={4}>No sessions yet</td></tr>
          )}
          {sessions.map(s => (
            <tr key={s.id}>
              <td>{s.id}</td>
              <td>{formatTime(s.startTime)}</td>
              <td>{formatTime(s.stopTime)}</td>
              <td>{s.durationMinutes ?? '—'}</td>
            </tr>
          ))}
        </tbody>
      </table>
      <footer className="version">v{__COMMIT_HASH__} · built {__BUILD_TIME__}</footer>
    </div>
  )
}
