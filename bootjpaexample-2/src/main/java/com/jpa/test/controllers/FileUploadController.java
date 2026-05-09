package com.jpa.test.controllers;

// Used for dependency injection
import org.springframework.beans.factory.annotation.Autowired;

// Used for HTTP status codes like 500, 200 etc.
import org.springframework.http.HttpStatus;

// Used to send custom response
import org.springframework.http.ResponseEntity;

// Used to map POST request
import org.springframework.web.bind.annotation.PostMapping;

// Used to receive request parameter
import org.springframework.web.bind.annotation.RequestParam;

// Marks this class as REST Controller
import org.springframework.web.bind.annotation.RestController;

// Used for file handling
import org.springframework.web.multipart.MultipartFile;

import com.jpa.test.helper.FileUploadHelper;

@RestController
public class FileUploadController {

    // Inject helper class object automatically
    @Autowired
    private FileUploadHelper fileUploadHelper;

    // API endpoint
    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(

            // Receive uploaded file from client
            @RequestParam("file") MultipartFile file) {

        try {

            // Check if file is empty
            if (file.isEmpty()) {

                return ResponseEntity
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Request must contain file");
            }

            // Allow only JPEG image
            // image/jpeg is MIME type for jpg/jpeg images
            if (!file.getContentType().equals("image/jpeg")) {

                return ResponseEntity
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("ONLY JPEG CONTENT TYPE ARE ALLOWED");
            }

            // Call helper class method for uploading file
            boolean f = fileUploadHelper.uploadFile(file);

            // If upload successful
            if (f) {

                return ResponseEntity.ok(
                        "File is successfully uploaded"
                );
            }

        } catch (Exception e) {

            // Print exception in console
            e.printStackTrace();
        }

        // If anything goes wrong
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Something went wrong");
    }
}