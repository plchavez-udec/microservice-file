package com.edu.udec.gdmtfl.msgdfiles.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.edu.udec.gdmtfl.msgdfiles.dtos.DTOBinary;
import com.edu.udec.gdmtfl.msgdfiles.dtos.DTOOutCreateFile;
import com.edu.udec.gdmtfl.msgdfiles.services.IBinaryService;

@RestController
@RequestMapping(value = "v1/file")
public class BinaryController {

	@Autowired
	private IBinaryService iBinaryService;

	@PostMapping("")
	public ResponseEntity<DTOOutCreateFile> uploadFile(@RequestParam("file") MultipartFile file) {
		DTOOutCreateFile fileCreate = iBinaryService.storeBinary(file);
		return ResponseEntity.ok(fileCreate);
	}

	@GetMapping(value = "/file/{id}")
	public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable("id") String id,
			@RequestParam(value = "fileName") final String keyName) {
		byte[] data = iBinaryService.getBinary(id);
		final ByteArrayResource resource = new ByteArrayResource(data);
		return ResponseEntity.ok().contentLength(data.length).header("Content-type", "application/octet-stream")
				.header("Content-disposition", "attachment; filename=\"" + keyName + "\"").body(resource);
	}
}
