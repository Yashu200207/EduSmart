import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { register } from "../services/authService";

function Register() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");
  const navigate = useNavigate();

  const handleRegister = async (e) => {
    e.preventDefault();
    try {
      await register({ username, password });
      navigate("/login"); // redirect to login
    } catch (err) {
      setError("You already have an account. Please login.");
    }
  };

  return (
    <div className="auth-container">
      <h2>Register</h2>
      <form onSubmit={handleRegister}>
        <input
          type="text"
          placeholder="Username"
          value={username}
          onChange={(e) => setUsername(e.target.value)}
          required
        />
        <input
          type="password"
          placeholder="Password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
          required
        />
        <button type="submit">Register</button>
      </form>
      {error && <p className="error">{error}</p>}
      <p>
        Already have an account?{" "}
        <span
          onClick={() => navigate("/login")}
          style={{ cursor: "pointer", color: "blue" }}
        >
          Login here
        </span>
      </p>
    </div>
  );
}

export default Register;
