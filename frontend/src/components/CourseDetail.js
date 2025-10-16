import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { getToken } from "../services/authService";

export default function CourseDetail() {
  const { id } = useParams();
  const [course, setCourse] = useState(null);

  useEffect(() => {
    fetch(`http://localhost:8080/courses/${id}`, {
      headers: { Authorization: `Bearer ${getToken()}` }
    })
      .then(res => res.json())
      .then(data => setCourse(data))
      .catch(err => console.error(err));
  }, [id]);

  if (!course) return <p>Loading course...</p>;

  return (
    <div style={{ padding: 20 }}>
      <h1>{course.title}</h1>
      <p><strong>Description:</strong> {course.description}</p>
      {course.courseInstructor && <p><strong>Instructor:</strong> {course.courseInstructor.username}</p>}
      <h3>Lessons / Modules</h3>
      <ul>
        {course.lessons && course.lessons.length > 0 ? (
          course.lessons.map((lesson, index) => <li key={index}>{lesson}</li>)
        ) : (
          <li>No lessons added yet</li>
        )}
      </ul>
    </div>
  );
}
