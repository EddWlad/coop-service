package com.greencode.coop_service.repositories;

import com.greencode.coop_service.entities.Cooperative;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ICooperativeRepository extends IGenericRepository<Cooperative, UUID> {
}
