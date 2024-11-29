package com.licenciatura.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class UploadController {

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            // Guardar el archivo en el servidor
            file.transferTo(new File("/data/licenciatura/backup.sql"));
            return "Archivo subido exitosamente";
        } catch (IOException e) {
            e.printStackTrace();
            return "Error al subir el archivo: " + e.getMessage();
        }
    }
}
