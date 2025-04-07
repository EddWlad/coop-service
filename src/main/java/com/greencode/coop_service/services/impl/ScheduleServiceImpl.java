package com.greencode.coop_service.services.impl;

import com.greencode.coop_service.entities.Schedule;
import com.greencode.coop_service.repositories.IGenericRepository;
import com.greencode.coop_service.repositories.IScheduleRepository;
import com.greencode.coop_service.services.IScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl extends GenericServiceImpl<Schedule, UUID> implements IScheduleService {
    private final IScheduleRepository scheduleRepository;


    @Override
    protected IGenericRepository<Schedule, UUID> getRepo() {
        return scheduleRepository;
    }
}
