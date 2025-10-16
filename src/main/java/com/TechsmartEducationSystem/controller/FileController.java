package com.TechsmartEducationSystem.controller;

import org.springframework.core.io.*;
import org.springframework.http.*;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.*;
import java.util.Map;

@RestController
@RequestMapping("/api/files")
public class FileController {

    private final Path root = Paths.get("uploads");

    public FileController() throws Exception { Files.createDirectories(root); }

    @PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) throws Exception {
        String filename = System.currentTimeMillis()+"_"+ StringUtils.cleanPath(file.getOriginalFilename());
        Files.copy(file.getInputStream(), root.resolve(filename), StandardCopyOption.REPLACE_EXISTING);
        return ResponseEntity.ok(Map.of("filename", filename));
    }

    @GetMapping("/download/{filename:.+}")
    public ResponseEntity<Resource> download(@PathVariable String filename) throws Exception{
        Path file = root.resolve(filename);
        Resource resource = new UrlResource(file.toUri());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+resource.getFilename()+"\"")
                .body(resource);
    }
}
