package com.greencode.coop_service.repositories;

import com.greencode.coop_service.entities.City;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ICityRepository extends IGenericRepository<City, UUID>{
}
