package com.jpa.test.helper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

    public final String UPLOAD_DIR =
            "C:\\Users\\Ritik Anand Kumar\\Documents\\001.STUDY\\01. Spring boot\\bootjpaexample-2\\src\\main\\resources\\static\\image";

    public boolean uploadFile(MultipartFile multipartFile) {

        boolean f = false;

        try {

            // create folder
            File file = new File(UPLOAD_DIR);

            if (!file.exists()) {
                file.mkdirs();
            }

            // file path
            Path path = Paths.get(
                    UPLOAD_DIR +
                            File.separator +
                            multipartFile.getOriginalFilename()
            );

            // copy file
            Files.copy(
                    multipartFile.getInputStream(),
                    path,
                    StandardCopyOption.REPLACE_EXISTING
            );

            f = true;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return f;
    }
}