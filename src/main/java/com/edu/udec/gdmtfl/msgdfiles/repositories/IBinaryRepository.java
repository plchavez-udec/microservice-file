package com.edu.udec.gdmtfl.msgdfiles.repositories;

import com.edu.udec.gdmtfl.msgdfiles.entities.BinaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IBinaryRepository extends JpaRepository<BinaryEntity, String> {

    Optional<BinaryEntity> findByName(String name);
    Optional<BinaryEntity> findByData(byte[] data);
}
