import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { getToken } from "../services/authService";

export default function Discussion() {
  const { courseId } = useParams();
  const [messages, setMessages] = useState([]);
  const [input, setInput] = useState("");

  useEffect(() => {
    fetch(`http://localhost:8080/discussions/course/${courseId}`, {
      headers: { Authorization: `Bearer ${getToken()}` }
    })
      .then(res => res.json())
      .then(data => setMessages(data))
      .catch(err => console.error(err));
  }, [courseId]);

  const handleSend = async () => {
    if (!input) return;
    const res = await fetch(`http://localhost:8080/discussions/course/${courseId}`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        Authorization: `Bearer ${getToken()}`
      },
      body: JSON.stringify({ message: input })
    });
    const newMessage = await res.json();
    setMessages([...messages, newMessage]);
    setInput("");
  };

  return (
    <div style={{ padding: 20 }}>
      <h2>Discussion Forum</h2>
      <ul>
        {messages.map((msg, index) => <li key={index}>{msg.message}</li>)}
      </ul>
      <input value={input} onChange={e => setInput(e.target.value)} placeholder="Write a message..." />
      <button onClick={handleSend}>Send</button>
    </div>
  );
}
