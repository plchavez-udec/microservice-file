package com.edu.udec.gdmtfl.msgdfiles.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.udec.gdmtfl.msgdfiles.entities.BinaryEntity;

@Repository
public interface IBinaryRepository extends JpaRepository<BinaryEntity, String> {

}
