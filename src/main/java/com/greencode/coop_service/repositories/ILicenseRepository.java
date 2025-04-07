package com.greencode.coop_service.repositories;

import com.greencode.coop_service.entities.License;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ILicenseRepository extends IGenericRepository<License, UUID>{
}
