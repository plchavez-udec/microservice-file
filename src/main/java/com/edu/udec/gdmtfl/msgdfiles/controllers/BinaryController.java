package com.edu.udec.gdmtfl.msgdfiles.controllers;

import com.edu.udec.gdmtfl.msgdfiles.dtos.DTOBinary;
import com.edu.udec.gdmtfl.msgdfiles.dtos.DTOOutCreateFile;
import com.edu.udec.gdmtfl.msgdfiles.dtos.DTOResponseMessage;
import com.edu.udec.gdmtfl.msgdfiles.repositories.IBinaryRepository;
import com.edu.udec.gdmtfl.msgdfiles.services.IBinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class BinaryController {

    @Autowired
    private IBinaryService iBinaryService;

    @PostMapping("/file")
    public ResponseEntity<DTOOutCreateFile> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            DTOOutCreateFile fileCreate = iBinaryService.storeBinary(file);
            return ResponseEntity.ok(fileCreate);
        } catch (Exception e) {
            //Esto debe ser corregido
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(value= "/file/{id}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable("id") String id, @RequestParam(value= "fileName") final String keyName) {
        DTOBinary binary= iBinaryService.getBinary(id);
        final byte[] data = binary.getData();
        final ByteArrayResource resource = new ByteArrayResource(data);
        return ResponseEntity
                .ok()
                .contentLength(data.length)
                .header("Content-type", "application/octet-stream")
                .header("Content-disposition", "attachment; filename=\"" + keyName + "\"")
                .body(resource);
    }
}
