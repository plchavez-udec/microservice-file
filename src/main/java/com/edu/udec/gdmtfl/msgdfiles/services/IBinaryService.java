package com.edu.udec.gdmtfl.msgdfiles.services;

import org.springframework.web.multipart.MultipartFile;

import com.edu.udec.gdmtfl.msgdfiles.dtos.DTOOutCreateFile;

public interface IBinaryService {
	DTOOutCreateFile storeBinary(MultipartFile file);
	byte[] getBinary(String id);
}
