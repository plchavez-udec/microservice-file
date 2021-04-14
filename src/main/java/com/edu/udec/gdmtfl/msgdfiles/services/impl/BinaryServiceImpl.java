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
import com.edu.udec.gdmtfl.msgdfiles.entities.FormatTypeEntity;
import com.edu.udec.gdmtfl.msgdfiles.exceptions.BinaryNonExistentException;
import com.edu.udec.gdmtfl.msgdfiles.repositories.IBinaryRepository;
import com.edu.udec.gdmtfl.msgdfiles.repositories.IFormatTypeRepository;
import com.edu.udec.gdmtfl.msgdfiles.services.IBinaryService;
import com.edu.udec.gdmtfl.msgdfiles.services.mapper.IMapper;

@Service
public class BinaryServiceImpl implements IBinaryService {

	@Autowired
	private IBinaryRepository iBinaryRepository;

	private IFormatTypeRepository formatTypeRepository;

	@Autowired
	private IMapper iMapper;

	@Override
	public DTOOutCreateFile storeBinary(MultipartFile file) throws IOException {

		long size = file.getSize();

		BinaryEntity fileDb = null;
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());

		// Validación de tipo de formato
		FormatTypeEntity formatType = this.formatTypeRepository.findByName(file.getContentType())
				.orElseThrow(() -> new NoSuchElementException("El documento no pertenece a un formato valido"));

		fileDb = new BinaryEntity(fileName, formatType, file.getBytes(), new Date());

		BinaryEntity response = null;
		DTOOutCreateFile outCreateFile = null;
		// Valida si el binario ya existe
		if (!iBinaryRepository.findByData(file.getBytes()).isPresent()) {
			// Si no existe guarda el binario
			response = iBinaryRepository.save(fileDb);
			// mapeo de campos de salida
			outCreateFile = iMapper.mapOutCreateFile(response);
			outCreateFile.setSize(size);
		} else {
			// Si si existe devuelve la info
			response = iBinaryRepository.findByData(file.getBytes()).get();
			outCreateFile = iMapper.mapOutCreateFile(response);
			outCreateFile.setSize(size);
		}
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
