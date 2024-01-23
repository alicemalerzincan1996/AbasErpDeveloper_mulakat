package com.cemal.repository;

import com.cemal.repository.entity.Mal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMalRepository extends JpaRepository<Mal,Long> {
}
