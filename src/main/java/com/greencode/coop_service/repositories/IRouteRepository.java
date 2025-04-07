package com.greencode.coop_service.repositories;

import com.greencode.coop_service.entities.Route;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IRouteRepository extends IGenericRepository<Route, UUID>{
}
