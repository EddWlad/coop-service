package com.greencode.coop_service.repositories;

import com.greencode.coop_service.entities.Fate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IFateRepository extends IGenericRepository<Fate, UUID>{
}
