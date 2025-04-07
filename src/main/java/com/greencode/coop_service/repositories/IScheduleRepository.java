package com.greencode.coop_service.repositories;

import com.greencode.coop_service.entities.Schedule;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IScheduleRepository extends IGenericRepository<Schedule, UUID>{
}
