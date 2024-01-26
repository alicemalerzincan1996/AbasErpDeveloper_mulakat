package com.cemal.repository;

import com.cemal.repository.entity.Mal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IMalRepository extends JpaRepository<Mal,Long> {
    Optional<Mal> findByMalnumarasi(String malnumarasi);
}
