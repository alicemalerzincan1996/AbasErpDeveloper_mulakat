package com.cemal.repository;

import com.cemal.repository.entity.Satilanurun;
import com.cemal.repository.entity.Siparis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISatilanurunRepository extends JpaRepository<Satilanurun,Long> {
}
