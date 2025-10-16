import React from "react";
import { useNavigate } from "react-router-dom";
import { logout } from "../services/authService";

function Dashboard() {
  const navigate = useNavigate();

  const handleLogout = () => {
    logout();
    navigate("/login");
  };

  return (
    <div className="dashboard-container">
      <h1>Welcome to Dashboard!</h1>
      <button onClick={handleLogout}>Logout</button>
    </div>
  );
}

export default Dashboard;
