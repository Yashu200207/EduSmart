// src/utils/auth.js

// ✅ Save token in browser localStorage
export const setToken = (token) => {
  localStorage.setItem("token", token);
};

// ✅ Get stored token
export const getToken = () => {
  return localStorage.getItem("token");
};

// ✅ Remove token on logout
export const removeToken = () => {
  localStorage.removeItem("token");
};

// ✅ Return authorization header for fetch requests
export const authHeader = () => {
  const token = getToken();
  return token ? { Authorization: `Bearer ${token}` } : {};
};
