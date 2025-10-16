import axios from "axios";

const API_URL = "http://localhost:8080/api"; // backend URL

export const register = async (user) => {
  const response = await axios.post(`${API_URL}/auth/register`, user);
  return response.data;
};

export const login = async (credentials) => {
  const response = await axios.post(`${API_URL}/auth/login`, credentials);
  if (response.data.token) {
    localStorage.setItem("token", response.data.token);
  }
  return response.data;
};

export const logout = () => {
  localStorage.removeItem("token");
};

export const getProfile = async () => {
  const token = localStorage.getItem("token");
  const response = await axios.get(`${API_URL}/auth/profile`, {
    headers: { Authorization: `Bearer ${token}` },
  });
  return response.data;
};

export const getToken = () => {
  return localStorage.getItem("token");
};
