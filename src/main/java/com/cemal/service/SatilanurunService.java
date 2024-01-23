package com.cemal.service;

import com.cemal.repository.ISatilanurunRepository;
import com.cemal.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class SatilanurunService extends ServiceManager {
    private final ISatilanurunRepository satilanurunRepository;

    public SatilanurunService(ISatilanurunRepository satilanurunRepository) {
        super(satilanurunRepository);
        this.satilanurunRepository = satilanurunRepository;
    }
}
