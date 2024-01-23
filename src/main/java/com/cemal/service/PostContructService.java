package com.cemal.service;

import com.cemal.repository.ISiparisRepository;
import com.cemal.repository.entity.Mal;
import com.cemal.repository.entity.Satilanurun;
import com.cemal.repository.entity.Siparis;
import com.cemal.utility.ServiceManager;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostContructService extends ServiceManager {
    private final SiparisService siparisService;
    private final SatilanurunService satilanurunService;
    private final MalService malService;
    private final ISiparisRepository iSiparisRepository;

    public PostContructService(SiparisService siparisService, SatilanurunService satilanurunService, MalService malService, ISiparisRepository iSiparisRepository) {
        super(iSiparisRepository);
        this.siparisService = siparisService;
        this.satilanurunService = satilanurunService;
        this.malService = malService;
        this.iSiparisRepository = iSiparisRepository;
    }

    @PostConstruct
    public void postconstruct(){
        Mal mal=Mal.builder().malnumarasi("2000").birim_fiyati_tl(100.0).build();
        if(malService.findAll().stream().anyMatch(a->a.getMalnumarasi().equals(mal.getMalnumarasi())));
        else {
            Mal mal2=Mal.builder().malnumarasi("2001").birim_fiyati_tl(100.0).build();
            Mal mal3=Mal.builder().malnumarasi("2002").birim_fiyati_tl(100.0).build();
            Mal mal4=Mal.builder().malnumarasi("2003").birim_fiyati_tl(100.0).build();
            Mal mal5=Mal.builder().malnumarasi("2004").birim_fiyati_tl(100.0).build();
            Mal mal6=Mal.builder().malnumarasi("2005").birim_fiyati_tl(100.0).build();
            Mal mal7=Mal.builder().malnumarasi("2006").birim_fiyati_tl(100.0).build();
            List<Mal> mallist=new ArrayList<>();
            mallist.add(mal);mallist.add(mal2);mallist.add(mal3);mallist.add(mal4);mallist.add(mal5);mallist.add(mal6);
            mallist.add(mal7);malService.saveAll(mallist);
            Satilanurun satilanurun=Satilanurun.builder().satilanfiyat(100.51).miktar(12).mal(mal).build();
            Satilanurun satilanurun1=Satilanurun.builder().satilanfiyat(200.0).miktar(31).mal(mal2).build();
            Satilanurun satilanurun2=Satilanurun.builder().satilanfiyat(150.86).miktar(22).mal(mal3).build();
            Satilanurun satilanurun3=Satilanurun.builder().satilanfiyat(250.0).miktar(41).mal(mal4).build();
            Satilanurun satilanurun4=Satilanurun.builder().satilanfiyat(244.0).miktar(55).mal(mal5).build();
            List<Satilanurun>satilanuruns1l=new ArrayList<>();
            satilanuruns1l.add(satilanurun);satilanuruns1l.add(satilanurun1);satilanuruns1l.add(satilanurun2);
            satilanuruns1l.add(satilanurun3);satilanuruns1l.add(satilanurun4);
            satilanurunService.saveAll(satilanuruns1l);
            Siparis siparis=Siparis.builder().satilanurunList(satilanuruns1l).id(1000l).build();


            Satilanurun satilanurun5=Satilanurun.builder().satilanfiyat(44.531).miktar(88).mal(mal2).build();
            Satilanurun satilanurun6=Satilanurun.builder().satilanfiyat(88.11).miktar(121).mal(mal3).build();
            Satilanurun satilanurun7=Satilanurun.builder().satilanfiyat(211.0).miktar(74).mal(mal5).build();
            Satilanurun satilanurun8=Satilanurun.builder().satilanfiyat(88.11).miktar(14).mal(mal3).build();
            List<Satilanurun>satilanuruns2l=new ArrayList<>();
            satilanuruns2l.add(satilanurun5);satilanuruns2l.add(satilanurun6);satilanuruns2l.add(satilanurun7);
            satilanuruns2l.add(satilanurun8);
            satilanurunService.saveAll(satilanuruns2l);
            Siparis siparis1=Siparis.builder().satilanurunList(satilanuruns2l).id(1001l).build();


            Satilanurun satilanurun9=Satilanurun.builder().satilanfiyat(12.1).miktar(2).mal(mal4).build();
            Satilanurun satilanurun10=Satilanurun.builder().satilanfiyat(22.3).miktar(3).mal(mal5).build();
            Satilanurun satilanurun11=Satilanurun.builder().satilanfiyat(12.1).miktar(8).mal(mal4).build();
            Satilanurun satilanurun12=Satilanurun.builder().satilanfiyat(94.0).miktar(16).mal(mal3).build();
            Satilanurun satilanurun13=Satilanurun.builder().satilanfiyat(44.1).miktar(9).mal(mal5).build();
            Satilanurun satilanurun14=Satilanurun.builder().satilanfiyat(90.0).miktar(19).mal(mal7).build();
            List<Satilanurun>satilanuruns3l=new ArrayList<>();
            satilanuruns3l.add(satilanurun9);satilanuruns3l.add(satilanurun10);satilanuruns3l.add(satilanurun11);
            satilanuruns3l.add(satilanurun12);satilanuruns3l.add(satilanurun13);satilanuruns3l.add(satilanurun14);
            satilanurunService.saveAll(satilanuruns3l);

            Siparis siparis2=Siparis.builder().satilanurunList(satilanuruns3l).id(1002l).build();
            siparisService.save(siparis);
            siparisService.save(siparis1);
            siparisService.save(siparis2);













        }
    }



}
