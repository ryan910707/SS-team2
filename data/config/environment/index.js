import dotenv from 'dotenv'

dotenv.config()

const port = process.env.PORT
const secret = process.env.SECRET
const version = process.env.VERSION

// Different situations
const env = {
  development: process.env.NODE_ENV === 'development',
  test: process.env.NODE_ENV === 'test',
  staging: process.env.NODE_ENV === 'staging',
  production: process.env.NODE_ENV === 'production'
}

// Database
const db = {
  host: process.env.DB_HOST,
  user: process.env.DB_USER,
  password: process.env.DB_PASS,
  name: process.env.DB_NAME,
  port: process.env.DB_PORT
}

// API
const api = {
  host: process.env.API_HOST,
  key: process.env.API_KEY
}

export { port, env, secret, db, version, api }
