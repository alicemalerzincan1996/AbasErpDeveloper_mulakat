package com.cemal.mapper;


import com.cemal.dto.request.Malsaverequest;
import com.cemal.dto.request.Malupdaterequest;
import com.cemal.dto.request.Siparissaverequest;
import com.cemal.dto.response.MalResponse;
import com.cemal.repository.entity.Mal;
import com.cemal.repository.entity.Siparis;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IMalveSiparisMapper {
    IMalveSiparisMapper INSTANCE= Mappers.getMapper(IMalveSiparisMapper.class);
    @Mapping(target = "malnumarasi",source = "name")
    Mal toMal(final Malsaverequest dto);
    Mal toMal(final Malupdaterequest dto);
    Siparis toSiparis(final Siparissaverequest dto);
    @Mapping(target = "name",source = "malnumarasi")
    MalResponse tomalresponse(final Mal dto);

}
