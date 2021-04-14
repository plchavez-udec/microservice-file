package com.edu.udec.gdmtfl.msgdfiles.services.mapper.impl;

import org.springframework.stereotype.Component;

import com.edu.udec.gdmtfl.msgdfiles.dtos.DTOBinary;
import com.edu.udec.gdmtfl.msgdfiles.dtos.DTOOutCreateFile;
import com.edu.udec.gdmtfl.msgdfiles.entities.BinaryEntity;
import com.edu.udec.gdmtfl.msgdfiles.services.mapper.IMapper;

@Component
public class MapperImpl implements IMapper {
	@Override
	public DTOBinary mapOutBinary(BinaryEntity binaryEntity) {
		DTOBinary dtoBinary = new DTOBinary();
		dtoBinary.setId(binaryEntity.getId());
		dtoBinary.setName(binaryEntity.getName());
		dtoBinary.setType(binaryEntity.getType().getName());
		dtoBinary.setData(binaryEntity.getData());
		return dtoBinary;
	}

	@Override
	public DTOOutCreateFile mapOutCreateFile(BinaryEntity binaryEntity) {

		DTOOutCreateFile outCreateFile = new DTOOutCreateFile();
		outCreateFile.setFile(binaryEntity.getId());
		outCreateFile.setContentType(binaryEntity.getType().getName());

		String family = binaryEntity.getName();
		String[] parts = family.split("\\.");
		;

		outCreateFile.setDocumentFamily(parts[parts.length - 1]);

		return outCreateFile;
	}
}
