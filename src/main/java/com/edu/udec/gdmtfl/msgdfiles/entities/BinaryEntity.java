package com.edu.udec.gdmtfl.msgdfiles.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "\"BINARIOS\"")
public class BinaryEntity {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "\"ID\"")
	private String id;

	@Column(name = "\"NOMBRE\"")
	private String name;

	@Column(name = "\"ID_TIPO_FORMATO_FK\"")
	private FormatTypeEntity formatType;

	@Lob
	@Type(type = "")
	@Column(name = "\"DATOS\"")
	private byte[] data;

	@Column(name = "\"FECHA_CREACION\"")
	private Date creationDate;

	public BinaryEntity() {

	}

	public BinaryEntity(String name, FormatTypeEntity formatType, byte[] data, Date creationDate) {
		this.name = name;
		this.formatType = formatType;
		this.data = data;
		this.creationDate = creationDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FormatTypeEntity getType() {
		return formatType;
	}

	public void setType(FormatTypeEntity formatType) {
		this.formatType = formatType;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

}
