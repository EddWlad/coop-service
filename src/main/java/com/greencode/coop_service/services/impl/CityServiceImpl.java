package com.greencode.coop_service.services.impl;

import com.greencode.coop_service.entities.City;
import com.greencode.coop_service.repositories.ICityRepository;
import com.greencode.coop_service.repositories.IGenericRepository;
import com.greencode.coop_service.services.ICityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CityServiceImpl extends GenericServiceImpl<City, UUID> implements ICityService {

    private final ICityRepository cityRepository;
    @Override
    protected IGenericRepository<City, UUID> getRepo() {
        return cityRepository;
    }
}
