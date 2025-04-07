package com.greencode.coop_service.repositories;

import com.greencode.coop_service.entities.Price;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IPriceRepository extends IGenericRepository<Price, UUID> {
}
