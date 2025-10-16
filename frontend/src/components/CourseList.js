import React, { useEffect, useState } from "react";
import { getToken } from "../services/authService";
import axios from "axios";

const CourseList = () => {
  const [courses, setCourses] = useState([]);

  useEffect(() => {
    const fetchCourses = async () => {
      const token = getToken();
      const response = await axios.get("http://localhost:8080/api/courses", {
        headers: { Authorization: `Bearer ${token}` },
      });
      setCourses(response.data);
    };

    fetchCourses();
  }, []);

  return (
    <div>
      <h2>Courses</h2>
      <ul>
        {courses.map((course) => (
          <li key={course.id}>{course.title}</li>
        ))}
      </ul>
    </div>
  );
};

export default CourseList;
