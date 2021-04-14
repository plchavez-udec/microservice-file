package com.edu.udec.gdmtfl.msgdfiles.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.udec.gdmtfl.msgdfiles.entities.FormatTypeEntity;

@Repository
public interface IFormatTypeRepository extends JpaRepository<FormatTypeEntity, String> {

	Optional<FormatTypeEntity> findByName(String name);

}
