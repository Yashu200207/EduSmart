import React, { useState } from "react";
import axios from "axios";

export default function CertificateGenerator() {
  const [username, setUsername] = useState("");
  const [courseId, setCourseId] = useState("");
  const [message, setMessage] = useState("");

  const generateCertificate = async () => {
    try {
      const res = await axios.post("http://localhost:8080/api/certificate/generate", { username, courseId }, {
        responseType: "blob"
      });
      const url = window.URL.createObjectURL(new Blob([res.data]));
      const link = document.createElement('a');
      link.href = url;
      link.setAttribute('download', 'certificate.pdf');
      document.body.appendChild(link);
      link.click();
      setMessage("Certificate downloaded!");
    } catch (err) {
      console.error(err);
      setMessage("Error generating certificate");
    }
  };

  return (
    <div style={{ padding: 20 }}>
      <h2>Certificate Generator</h2>
      <input placeholder="Username" value={username} onChange={e => setUsername(e.target.value)} />
      <input placeholder="Course ID" value={courseId} onChange={e => setCourseId(e.target.value)} />
      <button onClick={generateCertificate}>Generate Certificate</button>
      <p>{message}</p>
    </div>
  );
}
