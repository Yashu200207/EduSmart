package com.TechsmartEducationSystem.service;

import com.TechsmartEducationSystem.model.Certificate;
import com.TechsmartEducationSystem.repository.CertificateRepository;
import com.TechsmartEducationSystem.util.PdfGeneratorUtil;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class CertificateService {
    private final CertificateRepository repo;

    public CertificateService(CertificateRepository repo){ this.repo = repo; }

    public Certificate generateCertificate(String studentName, String courseName){
        Certificate cert = new Certificate();
        cert.setStudentName(studentName);
        cert.setCourseName(courseName);
        cert.setGeneratedAt(LocalDateTime.now());
        repo.save(cert);
        // Optionally generate PDF using PdfGeneratorUtil
        return cert;
    }
}
