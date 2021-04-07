package com.edu.udec.gdmtfl.msgdfiles.services.mapper;

import com.edu.udec.gdmtfl.msgdfiles.dtos.DTOBinary;
import com.edu.udec.gdmtfl.msgdfiles.dtos.DTOOutCreateFile;
import com.edu.udec.gdmtfl.msgdfiles.entities.BinaryEntity;
import org.springframework.stereotype.Component;

public interface IMapper {

    DTOBinary mapOutBinary(BinaryEntity binaryEntity);
    DTOOutCreateFile mapOutCreateFile(BinaryEntity binaryEntity);
}
