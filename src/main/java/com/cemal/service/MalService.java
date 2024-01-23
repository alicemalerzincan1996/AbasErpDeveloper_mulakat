package com.cemal.service;

import com.cemal.dto.request.Malsaverequest;
import com.cemal.dto.request.Malupdaterequest;
import com.cemal.dto.response.MalResponse;
import com.cemal.exception.EerrorType;
import com.cemal.exception.SiparisandMalException;
import com.cemal.mapper.IMalveSiparisMapper;
import com.cemal.repository.IMalRepository;
import com.cemal.repository.entity.Mal;
import com.cemal.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MalService extends ServiceManager<Mal,Long> implements Serializable {
    private final IMalRepository iMalRepository;
    private final IMalveSiparisMapper malveSiparisMapper;
    public MalService(IMalRepository iMalRepository, IMalveSiparisMapper malveSiparisMapper) {
        super(iMalRepository);
        this.iMalRepository = iMalRepository;
        this.malveSiparisMapper = malveSiparisMapper;
    }

    public Mal save (Malsaverequest malsaverequest){
        Mal mal=IMalveSiparisMapper.INSTANCE.toMal(malsaverequest);
        return save(mal);

    }
    public Mal update(Long id, Malupdaterequest malupdaterequest){
        Optional<Mal> malOptional=findById(id);
        if (malOptional.isPresent()){
            Mal mal=malOptional.get();

            Mal mal1=IMalveSiparisMapper.INSTANCE.toMal(malupdaterequest);
            mal.setMalnumarasi(mal1.getMalnumarasi());
            mal.setBirim_fiyati_tl(mal1.getBirim_fiyati_tl());
            return update(mal);
        }
        else throw new SiparisandMalException(EerrorType.Mal_BULUNAMADI);
    }
    public List<MalResponse> getall(){
        List<Mal>malList= findAll();
        List<MalResponse>malResponses=new ArrayList<>();
        for (int i = 0; i < malList.size(); i++) {
            malResponses.add(IMalveSiparisMapper.INSTANCE.tomalresponse(malList.get(i)));
        }

        return malResponses;
    };

    public Mal delete(Long id){

        Optional<Mal> malOptional=findById(id);
        if (malOptional.isPresent()){


             delete(malOptional.get());
             return malOptional.get();
        }
        else throw new SiparisandMalException(EerrorType.Mal_BULUNAMADI);
    }

}
