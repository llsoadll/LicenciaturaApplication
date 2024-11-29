package com.licenciatura.controller;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
public class BackupController {

    @GetMapping("/backup")
    public ResponseEntity<Resource> downloadBackup() {
        File file = new File("/data/licenciatura/backup.sql");
        Resource resource = new FileSystemResource(file);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=backup.sql")
                .body(resource);
    }
}
