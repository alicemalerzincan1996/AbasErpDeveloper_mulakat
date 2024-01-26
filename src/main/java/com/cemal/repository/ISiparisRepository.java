package com.cemal.repository;

import com.cemal.repository.entity.Siparis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISiparisRepository extends JpaRepository<Siparis,Long> {

}
