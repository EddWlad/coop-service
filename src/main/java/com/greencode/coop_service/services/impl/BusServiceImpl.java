package com.greencode.coop_service.services.impl;

import com.greencode.coop_service.entities.Bus;
import com.greencode.coop_service.repositories.IBusRepository;
import com.greencode.coop_service.repositories.IGenericRepository;
import com.greencode.coop_service.services.IBusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BusServiceImpl extends GenericServiceImpl<Bus, UUID> implements IBusService {
    private final IBusRepository busRepository;

    @Override
    protected IGenericRepository<Bus, UUID> getRepo() {
        return busRepository;
    }


}
