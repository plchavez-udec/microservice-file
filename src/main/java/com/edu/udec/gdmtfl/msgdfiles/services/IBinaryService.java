package com.edu.udec.gdmtfl.msgdfiles.services;

import com.edu.udec.gdmtfl.msgdfiles.dtos.DTOBinary;
import com.edu.udec.gdmtfl.msgdfiles.dtos.DTOOutCreateFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IBinaryService {

	DTOOutCreateFile storeBinary(MultipartFile file);
    DTOBinary getBinary(String id);
}
