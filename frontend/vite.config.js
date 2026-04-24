import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'
import { execSync } from 'child_process'

const commitHash = execSync('git rev-parse --short HEAD').toString().trim()
const buildTime = new Date().toLocaleString('sv-SE', { timeZone: 'Europe/Stockholm', hour12: false }).replace('T', ' ')

export default defineConfig({
  plugins: [react()],
  define: {
    __COMMIT_HASH__: JSON.stringify(commitHash),
    __BUILD_TIME__: JSON.stringify(buildTime),
  },
  server: {
    host: true,
    allowedHosts: true,
    proxy: {
      '/api': {
        target: 'http://localhost:8080',
        configure: (proxy) => {
          proxy.on('proxyReq', (_, req) => console.log('[proxy]', req.method, req.url))
          proxy.on('error', (err) => console.log('[proxy error]', err.message))
        },
      },
    },
  },
})
