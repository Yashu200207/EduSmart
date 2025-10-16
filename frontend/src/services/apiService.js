import { getToken } from "./authService";
const BASE = "http://localhost:8080";

const headers = () => ({
  "Content-Type": "application/json",
  Authorization: `Bearer ${getToken()}`
});

export const getEnrollments = async (username) => {
  const res = await fetch(`${BASE}/api/dashboard/enrollments/${username}`, { headers: headers() });
  return res.json();
};

export const enrollCourse = async (username, courseId) => {
  const res = await fetch(`${BASE}/api/dashboard/enroll/${username}/${courseId}`, {
    method: "POST",
    headers: headers()
  });
  return res.json();
};

export const updateProgress = async (username, courseId, progress) => {
  const res = await fetch(`${BASE}/api/dashboard/progress/${username}/${courseId}`, {
    method: "POST",
    headers: headers(),
    body: JSON.stringify({ progress })
  });
  return res.json();
};
