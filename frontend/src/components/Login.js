import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { login } from "../services/authService";

function Login() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");
  const navigate = useNavigate();

  const handleLogin = async (e) => {
    e.preventDefault();
    try {
      await login({ username, password });
      navigate("/dashboard");
    } catch (err) {
      setError("Invalid credentials. Please try again.");
    }
  };

  return (
    <div className="auth-container">
      <h2>Login</h2>
      <form onSubmit={handleLogin}>
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
        <button type="submit">Login</button>
      </form>
      {error && <p className="error">{error}</p>}
      <p>
        Don't have an account?{" "}
        <span
          onClick={() => navigate("/register")}
          style={{ cursor: "pointer", color: "blue" }}
        >
          Register here
        </span>
      </p>
    </div>
  );
}

export default Login;
