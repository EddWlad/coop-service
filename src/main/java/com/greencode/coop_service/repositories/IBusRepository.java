package com.greencode.coop_service.repositories;

import com.greencode.coop_service.entities.Bus;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IBusRepository extends IGenericRepository<Bus, UUID>{
}
