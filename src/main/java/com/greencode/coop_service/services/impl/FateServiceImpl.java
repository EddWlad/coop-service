package com.greencode.coop_service.services.impl;

import com.greencode.coop_service.entities.Fate;
import com.greencode.coop_service.entities.Price;
import com.greencode.coop_service.repositories.IFatePriceRepository;
import com.greencode.coop_service.repositories.IFateRepository;
import com.greencode.coop_service.repositories.IGenericRepository;
import com.greencode.coop_service.services.IFateService;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FateServiceImpl extends GenericServiceImpl<Fate, UUID> implements IFateService {
    private final IFateRepository fateRepository;
    private final IFatePriceRepository fpRepo;


    @Override
    public Fate saveTransactional(Fate fate, List<Price> prices) throws Exception {
        fateRepository.save(fate);
        prices.forEach(price -> fpRepo.saveTransactional(fate.getIdFate(), price.getIdPrice()));
        return fate;
    }

    @Override
    @Transactional
    protected IGenericRepository<Fate, UUID> getRepo() {
        return fateRepository;
    }
}
