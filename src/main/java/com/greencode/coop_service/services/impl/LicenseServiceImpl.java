package com.greencode.coop_service.services.impl;

import com.greencode.coop_service.entities.License;
import com.greencode.coop_service.repositories.IGenericRepository;
import com.greencode.coop_service.repositories.ILicenseRepository;
import com.greencode.coop_service.services.ILicenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LicenseServiceImpl extends GenericServiceImpl<License, UUID> implements ILicenseService {
    private final ILicenseRepository licenseRepository;


    @Override
    protected IGenericRepository<License, UUID> getRepo() {
        return licenseRepository;
    }
}
