package com.edu.udec.gdmtfl.msgdfiles.entities;

import java.util.Arrays;
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
	@Column(name = "\"TIPO_CONTENIDO\"")
	private String contentType;
	@Column(name = "\"FAMILIA\"")
	private String family;
	@Column(name = "\"TAMANO\"")
	private long size;
	@Column(name = "\"UNIDAD\"")
	private String unit;
	@Column(name = "\"NOMBRE\"")
	private String name;
	@Lob
	@Type(type = "")
	@Column(name = "\"DATOS\"")
	private byte[] data;
	@Column(name = "\"FECHA_CREACION\"")
	private Date creationDate;

	public String getId() {
		return id;
	}

	public String getContentType() {
		return contentType;
	}

	public String getFamily() {
		return family;
	}

	public long getSize() {
		return size;
	}

	public byte[] getData() {
		return data;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Override
	public String toString() {
		return "BinaryEntity [id=" + id + ", contentType=" + contentType + ", family=" + family + ", size=" + size
				+ ", unit=" + unit + ", name=" + name + ", data=" + Arrays.toString(data) + ", creationDate="
				+ creationDate + "]";
	}

}
