package com.edu.udec.gdmtfl.msgdfiles.services.impl;

import java.io.IOException;
import java.util.Date;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.edu.udec.gdmtfl.msgdfiles.dtos.DTOBinary;
import com.edu.udec.gdmtfl.msgdfiles.dtos.DTOOutCreateFile;
import com.edu.udec.gdmtfl.msgdfiles.entities.BinaryEntity;
import com.edu.udec.gdmtfl.msgdfiles.exceptions.BinaryNonExistentException;
import com.edu.udec.gdmtfl.msgdfiles.exceptions.GeneralException;
import com.edu.udec.gdmtfl.msgdfiles.repositories.IBinaryRepository;
import com.edu.udec.gdmtfl.msgdfiles.repositories.IFormatTypeRepository;
import com.edu.udec.gdmtfl.msgdfiles.services.IBinaryService;
import com.edu.udec.gdmtfl.msgdfiles.services.mapper.IMapper;

@Service
public class BinaryServiceImpl implements IBinaryService {

	@Autowired
	private IBinaryRepository iBinaryRepository;

	@Autowired
	private IFormatTypeRepository formatTypeRepository;

	@Autowired
	private IMapper iMapper;

	@Override
	public DTOOutCreateFile storeBinary(MultipartFile file) {
		DTOOutCreateFile outCreateFile = null;
		// Validación de tipo de formato
		this.formatTypeRepository.findByName(file.getContentType())
				.orElseThrow(() -> new NoSuchElementException("El documento no pertenece a un formato valido"));

		BinaryEntity fileDb = null;
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		String[] parts = fileName.split("\\.");
		try {
			fileDb = new BinaryEntity();
			fileDb.setContentType(file.getContentType());
			fileDb.setFamily(parts[parts.length - 1]);
			fileDb.setSize(file.getSize());
			fileDb.setData(file.getBytes());
			fileDb.setCreationDate(new Date());
		} catch (IOException e) {
			throw new GeneralException("Ocurrio un error a la hora de cargar el archivo");
		}
		fileDb = iBinaryRepository.save(fileDb);
		// mapeo de campos de salida
		outCreateFile = iMapper.mapOutCreateFile(fileDb);
		return outCreateFile;
	}

	@Override
	public DTOBinary getBinary(String id) {
		BinaryEntity binaryEntity = iBinaryRepository.findById(id)
				.orElseThrow(() -> new BinaryNonExistentException(id));
		DTOBinary dtoBinary = iMapper.mapOutBinary(binaryEntity);
		return dtoBinary;
	}

}
