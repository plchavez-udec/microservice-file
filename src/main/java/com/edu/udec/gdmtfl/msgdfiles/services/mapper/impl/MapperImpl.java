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
		/*
		 * DTOBinary dtoBinary = new DTOBinary(); dtoBinary.setId(binaryEntity.getId());
		 * dtoBinary.setName(binaryEntity.getName());
		 * dtoBinary.setData(binaryEntity.getData());
		 */
		return null;
	}

	@Override
	public DTOOutCreateFile mapOutCreateFile(BinaryEntity binaryEntity) {
		DTOOutCreateFile outCreateFile = new DTOOutCreateFile();
		outCreateFile.setFile(binaryEntity.getId());
		outCreateFile.setContentType(binaryEntity.getContentType());
		outCreateFile.setSize(binaryEntity.getSize());
		outCreateFile.setDocumentFamily(binaryEntity.getFamily());
		outCreateFile.setName(binaryEntity.getName());
		return outCreateFile;
	}
}
