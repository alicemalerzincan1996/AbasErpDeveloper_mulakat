package com.cemal.repository;

import com.cemal.repository.entity.Satilanurun;
import com.cemal.repository.entity.Siparis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISatilanurunRepository extends JpaRepository<Satilanurun,Long> {
    List<Satilanurun> findByMiktarGreaterThanAndSatilanfiyatLessThan(Integer miktar, Double satilanfiyat);
    List<Satilanurun> findByMiktarGreaterThanEqualAndSatilanfiyatLessThanEqual(Integer miktar, Double satilanfiyat);
    @Query("SELECT s FROM Satilanurun s WHERE s.miktar >= :miktar AND s.satilanfiyat <= :satilanfiyat")
    List<Satilanurun> findSatilanurunByMiktarAndFiyat(Integer miktar, Double satilanfiyat);

}
