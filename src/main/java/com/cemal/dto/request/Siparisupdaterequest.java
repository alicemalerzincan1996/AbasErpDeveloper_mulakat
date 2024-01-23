package com.cemal.dto.request;

import com.cemal.repository.entity.Mal;
import com.cemal.repository.entity.Satilanurun;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Builder // bir sınıftan nesne türetmeyi sağlar.
@Data //get set metodlarını otomatik tanımlar.
@NoArgsConstructor //boş constructor oluşturur.
@AllArgsConstructor //dolu constructor oluşturur.
public class Siparisupdaterequest {
    List<Satilanurun> satilanuruns;


}
