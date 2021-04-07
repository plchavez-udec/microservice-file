package com.edu.udec.gdmtfl.msgdfiles.entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import java.util.Date;

import javax.persistence.*;

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

	@Column(name = "\"TIPO_CONTENIDO\"")
	private String type;

	@Lob
	@Type(type = "")
	@Column(name = "\"DATOS\"")
	private byte[] data;

	@Column(name = "\"FECHA_CREACION\"")
	private Date creationDate;

	public BinaryEntity() {

	}

	public BinaryEntity(String name, String type, byte[] data, Date creationDate) {
        this.name = name;
        this.type = type;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
