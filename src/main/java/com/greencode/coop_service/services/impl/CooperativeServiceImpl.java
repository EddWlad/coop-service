package com.greencode.coop_service.services.impl;

import com.greencode.coop_service.entities.Cooperative;
import com.greencode.coop_service.entities.Fate;
import com.greencode.coop_service.repositories.ICooperativeFateRepository;
import com.greencode.coop_service.repositories.ICooperativeRepository;
import com.greencode.coop_service.repositories.IGenericRepository;
import com.greencode.coop_service.services.ICooperativeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CooperativeServiceImpl extends GenericServiceImpl<Cooperative, UUID> implements ICooperativeService {
    private final ICooperativeRepository cooperativeRepository;
    private final ICooperativeFateRepository cfRepo;

    @Override
    @Transactional
    public Cooperative saveTransactional(Cooperative cooperative, List<Fate> fates) throws Exception {
        cooperativeRepository.save(cooperative);
        fates.forEach(fa -> cfRepo.saveTransactional(cooperative.getIdCoop(), fa.getIdFate()));
        return cooperative;
    }

    @Override
    protected IGenericRepository<Cooperative, UUID> getRepo() {
        return cooperativeRepository;
    }
}
