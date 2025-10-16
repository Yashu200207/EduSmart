import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

function Signup() {
  const navigate = useNavigate();
  const [form, setForm] = useState({ username: "", password: "" });
  const [message, setMessage] = useState("");

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const res = await fetch("http://localhost:8080/api/auth/signup", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(form),
      });

      const data = await res.json();

      if (res.ok) {
        setMessage("Signup successful! Redirecting to login...");
        setTimeout(() => navigate("/login"), 1500);
      } else {
        setMessage(data.error || "Signup failed");
      }
    } catch (error) {
      setMessage("Server error. Please try again.");
    }
  };

  return (
    <div className="form-container">
      <h2>Signup</h2>
      <form onSubmit={handleSubmit}>
        <input
          name="username"
          placeholder="Username"
          value={form.username}
          onChange={handleChange}
          required
        />
        <input
          name="password"
          type="password"
          placeholder="Password"
          value={form.password}
          onChange={handleChange}
          required
        />
        <button type="submit">Signup</button>
      </form>
      <p className="message">{message}</p>
      <p>
        Already registered?{" "}
        <span className="link" onClick={() => navigate("/login")}>
          Login
        </span>
      </p>
    </div>
  );
}

export default Signup;
