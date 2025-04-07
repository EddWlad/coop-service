package com.greencode.coop_service.repositories;

import com.greencode.coop_service.entities.Staff;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IStaffRepository extends IGenericRepository<Staff, UUID>{
}
