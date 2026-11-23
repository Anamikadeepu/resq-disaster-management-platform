# ResQ — Disaster Management Platform

Three role-based portals (Citizen, Responder, Admin) for real-time incident reporting,
SOS dispatch, and rescue coordination.

- `backend/` — Spring Boot REST API + PostgreSQL
- `frontend/` — React (Vite) app
- `docs/` — architecture notes

## Local development

**Backend:**
```
cd backend
mvn spring-boot:run
```

**Frontend:**
```
cd frontend
npm install
npm run dev
```

## Deployment

- Backend + PostgreSQL: Render
- Frontend: Vercel
