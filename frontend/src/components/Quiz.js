import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { getToken } from "../services/authService";

export default function Quiz() {
  const { courseId } = useParams();
  const [quizzes, setQuizzes] = useState([]);

  useEffect(() => {
    fetch(`http://localhost:8080/quizzes/course/${courseId}`, {
      headers: { Authorization: `Bearer ${getToken()}` }
    })
      .then(res => res.json())
      .then(data => setQuizzes(data))
      .catch(err => console.error(err));
  }, [courseId]);

  return (
    <div style={{ padding: 20 }}>
      <h2>Quizzes</h2>
      <ul>
        {quizzes.map(quiz => (
          <li key={quiz.id}>{quiz.title}</li>
        ))}
      </ul>
    </div>
  );
}
