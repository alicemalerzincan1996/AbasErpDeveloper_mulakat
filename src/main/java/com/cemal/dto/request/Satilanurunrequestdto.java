package com.cemal.dto.request;

import com.cemal.repository.entity.Satilanurun;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder // bir sınıftan nesne türetmeyi sağlar.
@Data //get set metodlarını otomatik tanımlar.
@NoArgsConstructor //boş constructor oluşturur.
@AllArgsConstructor //dolu constructor oluşturur.
public class Satilanurunrequestdto {
    private Long urunid;

    private Integer adet;

    private Double fiyat;
}
