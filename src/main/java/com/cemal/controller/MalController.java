package com.cemal.controller;

import com.cemal.dto.request.Malsaverequest;
import com.cemal.dto.request.Malupdaterequest;
import com.cemal.dto.response.MalResponse;
import com.cemal.repository.entity.Mal;
import com.cemal.service.MalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.cemal.constants.EndPoints.*;
@CrossOrigin(origins = "*") // React uygulamanızın çalıştığı adres

@RestController
@RequestMapping(MAL)
public class MalController {
    private final MalService malService;
    @Autowired
    public MalController(MalService malService) {
        this.malService = malService;
    }

    @PostMapping(SAVE)
    public Mal malsave(@RequestBody Malsaverequest malsaverequest){
        return malService.save(malsaverequest);
    }
    @PutMapping(UPDATE)
    public Mal malupdate(@RequestBody Malupdaterequest malupdaterequest,@RequestParam Long id){
        return malService.update(id,malupdaterequest);
    }
    @GetMapping(GETALL)
    public List<MalResponse> getall(){

        return malService.getall();
    }

    @DeleteMapping(DELETE)
    public Mal maldelete(@RequestParam Long id){
        return malService.delete(id);
    }
}
