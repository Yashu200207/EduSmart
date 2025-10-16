package com.TechsmartEducationSystem.controller;

import com.TechsmartEducationSystem.model.Course;
import com.TechsmartEducationSystem.model.User;
import com.TechsmartEducationSystem.repository.CourseRepository;
import com.TechsmartEducationSystem.repository.UserRepository;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;

@RestController
@RequestMapping("/api/certificates")
@RequiredArgsConstructor
public class CertificateController {

    private final UserRepository userRepo;
    private final CourseRepository courseRepo;

    @GetMapping("/generate/{username}/{courseName}")
    public ResponseEntity<byte[]> generate(@PathVariable String username, @PathVariable String courseName) throws Exception {
        User u = userRepo.findByUsername(username).orElseThrow();
        Course c = courseRepo.findByTitle(courseName).orElseThrow();

        Document doc = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PdfWriter.getInstance(doc, out);
        doc.open();
        doc.add(new Paragraph("Certificate of Completion"));
        doc.add(new Paragraph("This certifies that " + u.getUsername() + " completed " + c.getTitle()));
        doc.close();

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=certificate.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(out.toByteArray());
    }
}
