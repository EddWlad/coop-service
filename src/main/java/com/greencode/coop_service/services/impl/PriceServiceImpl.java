package com.greencode.coop_service.services.impl;

import com.greencode.coop_service.entities.Price;
import com.greencode.coop_service.repositories.IGenericRepository;
import com.greencode.coop_service.repositories.IPriceRepository;
import com.greencode.coop_service.services.IPriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PriceServiceImpl extends GenericServiceImpl<Price, UUID> implements IPriceService {
    private final IPriceRepository priceRepository;


    @Override
    protected IGenericRepository<Price, UUID> getRepo() {
        return priceRepository;
    }
}
