package com.microservice.Image.repository;

import com.microservice.Image.model.FileDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FileDBRepository extends JpaRepository<FileDB, Long> {
    Optional<FileDB> findByPhoneId(Long phoneId);
}
