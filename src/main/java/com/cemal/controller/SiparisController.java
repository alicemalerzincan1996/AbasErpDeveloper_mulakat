package com.cemal.controller;

import com.cemal.dto.request.SepetItem;
import com.cemal.dto.request.SepetxItem;
import com.cemal.dto.request.Siparissaverequest;
import com.cemal.dto.request.Siparisupdaterequest;
import com.cemal.dto.response.Tektekmalbazlıbilgiler;
import com.cemal.repository.entity.Siparis;
import com.cemal.service.SiparisService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static com.cemal.constants.EndPoints.*;
@CrossOrigin(origins = "*")// React uygulamanızın çalıştığı adres
@RestController
@RequestMapping(Siparis)
public class SiparisController {
    private final SiparisService siparisService;

    public SiparisController(SiparisService siparisService) {
        this.siparisService = siparisService;
    }
    @PostMapping(SAVE+"x")
    public Siparis save(@RequestBody List<SepetItem> sepetItems){


        return siparisService.save(sepetItems);
    }
    @PutMapping(UPDATE)
    public Siparis update(@RequestParam Long id,@RequestBody Siparisupdaterequest siparisupdaterequest){
        return siparisService.update(id,siparisupdaterequest);
    }
    @GetMapping(GETALL)
    public List<Siparis> getall(){
        return siparisService.findAll();
    }
    @DeleteMapping(DELETE)
    public Siparis delete(@RequestParam Long id){
        return siparisService.delete(id);
    }

    @PostMapping(Siparistoplama)
    public Double siparisToplaminiHesapla(@RequestBody List<SepetxItem> sepet) {
       return siparisService.sipraistoplama(sepet);
    }
    @PostMapping(Siparisortalama)
    public Double siparisortalamaHesapla(@RequestBody List<SepetxItem> sepet) {
        return siparisService.sipraisortalama(sepet);
    }
    @PostMapping(MalSiparisortalama)
    Map<String, Double> malsipraisortalama(@RequestBody List<SepetxItem> sepet){
        return siparisService.malsipraisortalama(sepet);
    }
    @PostMapping(MalBazliSiparisadet)
    public List<Tektekmalbazlıbilgiler> malbazlisipraisadet(@RequestBody List<SepetxItem> sepet)
    {
        return siparisService.malbazlisipraisadet(sepet);
    }

}
