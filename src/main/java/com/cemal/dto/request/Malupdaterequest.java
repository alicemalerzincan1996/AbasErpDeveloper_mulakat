package com.cemal.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Builder // bir sınıftan nesne türetmeyi sağlar.
@Data //get set metodlarını otomatik tanımlar.
@NoArgsConstructor //boş constructor oluşturur.
@AllArgsConstructor //dolu constructor oluşturur.
public class Malupdaterequest {
    @NotBlank(message = "Mal adı boş geçilemez.")
    @Size(min=3,max=30)
    String name;
    @NotBlank(message = "fiyat bos gecilemez.")
    Double birim_fiyati_tl;
}
