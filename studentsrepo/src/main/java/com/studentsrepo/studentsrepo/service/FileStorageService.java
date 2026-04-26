package com.studentsrepo.studentsrepo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class FileStorageService {// Definimos dónde se guardarán los archivos
    private final Path root = Paths.get("uploads");

    public FileStorageService() {
        try {
            // Si la carpeta 'uploads' no existe, la crea apenas inicie el programa
            if (!Files.exists(root)) {
                Files.createDirectory(root);
            }
        } catch (IOException e) {
            throw new RuntimeException("¡No pude crear la carpeta para los PDF!");
        }
    }

    public String save(MultipartFile file) {
        try {
            // Le damos un nombre único al archivo para que no se sobreescriban
            // Ejemplo: a1b2-c3d4-archivo.pdf
            String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();

            Files.copy(file.getInputStream(), this.root.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);

            return fileName; // Devolvemos el nombre para guardarlo en la DB
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar el archivo: " + e.getMessage());
        }
    }
}

