package com.cemal.service;

import com.cemal.dto.request.SepetItem;
import com.cemal.dto.request.SepetxItem;
import com.cemal.dto.request.Siparisupdaterequest;
import com.cemal.dto.response.Tektekmalbazlıbilgiler;
import com.cemal.exception.EerrorType;
import com.cemal.exception.SiparisandMalException;
import com.cemal.mapper.IMalveSiparisMapper;
import com.cemal.repository.ISiparisRepository;
import com.cemal.repository.entity.Mal;
import com.cemal.repository.entity.Satilanurun;
import com.cemal.repository.entity.Siparis;
import com.cemal.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class SiparisService extends ServiceManager<Siparis,Long> implements Serializable {
    private final ISiparisRepository iSiparisRepository;
    private final MalService malService;
    private final SatilanurunService satilanurunService;
    private final IMalveSiparisMapper malveSiparisMapper;

    public SiparisService(ISiparisRepository iSiparisRepository, MalService malService, SatilanurunService satilanurunService, IMalveSiparisMapper malveSiparisMapper) {
        super(iSiparisRepository);
        this.iSiparisRepository = iSiparisRepository;
        this.malService = malService;
        this.satilanurunService = satilanurunService;
        this.malveSiparisMapper = malveSiparisMapper;
    }
    public Siparis save(List<SepetItem> sepetItems){
        List< Satilanurun> satilanuruns =new ArrayList<>();
        for (int i = 0; i < sepetItems.size(); i++) {
            Optional<Mal> mal =malService.findById(sepetItems.get(i).getId());
            if (mal.isPresent()) {
                Satilanurun satilanurun=Satilanurun.builder().mal(mal.get()).
                        satilanfiyat(sepetItems.get(i).getSatilanFiyat()).miktar(sepetItems.get(i).getAdet()).build();
                satilanuruns.add(satilanurun);

            }
        }
        satilanurunService.saveAll(satilanuruns);

        Siparis siparis=Siparis.builder().satilanurunList(satilanuruns).build();

        return save(siparis);
    }


    public Siparis update(Long id,Siparisupdaterequest siparisupdaterequest){
        Optional<Siparis> optionalSiparis=findById(id);
        if (optionalSiparis.isPresent()){
            Siparis siparis=optionalSiparis.get();
            siparis.setSatilanurunList(siparisupdaterequest.getSatilanuruns());
            return update(siparis);
        }
        else throw new SiparisandMalException(EerrorType.Siparis_BULUNAMADI);
    }

    public Siparis delete(Long id){
        Optional<Siparis> optionalSiparis=findById(id);
        if (optionalSiparis.isPresent()){

            delete(optionalSiparis.get());
            return optionalSiparis.get();
        }
        else throw new SiparisandMalException(EerrorType.Siparis_BULUNAMADI);
    }

    public Double sipraistoplama( List<SepetxItem> sepet){
        Double toplam=0.0;
        List<Siparis> siparisList=new ArrayList<>();
        for (int i = 0; i < sepet.size(); i++) {
            Optional<Siparis> siparis=findById(sepet.get(i).getSiparisId());
            if (siparis.isPresent()){
                siparisList.add(siparis.get());
            }
        }
        for (Siparis siparis : siparisList) {
            double siparisToplami = siparis.getSatilanurunList()
                    .stream()
                    .mapToDouble(a -> a.getSatilanfiyat() * a.getMiktar())
                    .sum();
            toplam += siparisToplami;
        }


        return toplam;
    }

    public Double sipraisortalama(List<SepetxItem> sepet){

        Double ortalama=0.0;
        List<Siparis> siparisList=new ArrayList<>();
        for (int i = 0; i < sepet.size(); i++) {
            Optional<Siparis> siparis=findById(sepet.get(i).getSiparisId());
            if (siparis.isPresent()){
                siparisList.add(siparis.get());
            }
        }
        for (Siparis siparis : siparisList) {
            double siparisOrtalamasi = siparis.getSatilanurunList()
                    .stream()
                    .mapToDouble(a -> a.getSatilanfiyat() * a.getMiktar())
                    .average()
                    .orElse(0.0);
            ortalama += siparisOrtalamasi;
        }


        return ortalama;
    }

    public Map<String, Double> malsipraisortalama(List<SepetxItem> sepet){
        List<Siparis> siparisList=new ArrayList<>();
        for (int i = 0; i < sepet.size(); i++) {
            Optional<Siparis> siparis=findById(sepet.get(i).getSiparisId());
            if (siparis.isPresent()){
                siparisList.add(siparis.get());
            }
        }
        Double toplam=0.0;
        int malsayisi=0;
        Map<String,Double> ortalama_malbazlifiyatlar=new HashMap<>();
        List<Satilanurun> satilanuruns = siparisList.stream()
                .flatMap(siparis -> siparis.getSatilanurunList().stream())
                .collect(Collectors.toList());
        for (int i = 0; i < satilanuruns.size(); i++) {
            String malnumarasi=satilanuruns.get(i).getMal().getMalnumarasi();
            Double ortalama=satilanuruns.stream().
                    filter(a->a.getMal().getMalnumarasi().equals(malnumarasi)).mapToDouble(a -> a.getSatilanfiyat() * a.getMiktar())
                    .average()
                    .orElse(0.0);
            ortalama_malbazlifiyatlar.put(malnumarasi,ortalama);


        }




        return ortalama_malbazlifiyatlar;
    }

    public List<Tektekmalbazlıbilgiler> malbazlisipraisadet(List<SepetxItem> sepet)
    {List<Siparis> siparisList=new ArrayList<>();
        for (int i = 0; i < sepet.size(); i++) {
            Optional<Siparis> siparis=findById(sepet.get(i).getSiparisId());
            if (siparis.isPresent()){
                siparisList.add(siparis.get());
            }
        }
        List<Tektekmalbazlıbilgiler>tektekmalbazlıbilgilerlist=new ArrayList<>();
        List<Satilanurun> satilanuruns = siparisList.stream()
            .flatMap(siparis -> siparis.getSatilanurunList().stream())
            .collect(Collectors.toList());
        Integer miktar=0;
        for (int i = 0; i < satilanuruns.size(); i++) {
            String malnumarasi=satilanuruns.get(i).getMal().getMalnumarasi();
            for (int j = 0; j < siparisList.size(); j++) {
                Long siparisnumarasi=siparisList.get(j).getId();
                miktar=siparisList.get(j)
                        .getSatilanurunList()
                        .stream().filter(a -> a.getMal().getMalnumarasi().equals(malnumarasi))
                        .mapToInt(Satilanurun::getMiktar)
                        .sum();
                Tektekmalbazlıbilgiler tektekmalbazlıbilgiler=Tektekmalbazlıbilgiler.builder().
                        malnumarasi(malnumarasi).siparisnumarasi(siparisnumarasi).miktar(miktar).build();
               if( siparisList.get(j).getSatilanurunList().stream().anyMatch(a -> a.getMal().getMalnumarasi().equals(malnumarasi)))
                if (!tektekmalbazlıbilgilerlist.stream().anyMatch(a -> a.getMalnumarasi().equals(malnumarasi)&&a.getSiparisnumarasi().equals(siparisnumarasi))) {
                    tektekmalbazlıbilgilerlist.add(tektekmalbazlıbilgiler);
                }

        }



    }
        return tektekmalbazlıbilgilerlist;

}
}
