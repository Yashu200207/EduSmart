package com.TechsmartEducationSystem.util;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;

public class PdfGeneratorUtil {
    public static byte[] generateCertificate(String studentName, String courseName) throws Exception {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, out);

        document.open();
        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20);
        Font textFont = FontFactory.getFont(FontFactory.HELVETICA, 14);

        Paragraph title = new Paragraph("Certificate of Completion", titleFont);
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);
        document.add(new Paragraph(" "));

        Paragraph content = new Paragraph(
            "This certifies that " + studentName + " has successfully completed the course: " + courseName,
            textFont
        );
        content.setAlignment(Element.ALIGN_CENTER);
        document.add(content);

        document.close();
        return out.toByteArray();
    }
}
