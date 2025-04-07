package com.greencode.coop_service.services.impl;

import com.greencode.coop_service.entities.Staff;
import com.greencode.coop_service.repositories.IGenericRepository;
import com.greencode.coop_service.repositories.IStaffRepository;
import com.greencode.coop_service.services.IStaffService;
import com.greencode.coop_service.utils.ApiAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StaffServiceImpl extends GenericServiceImpl<Staff, UUID> implements IStaffService {
    private final IStaffRepository staffRepository;
    private final ApiAdapter apiAdapter;


    @Override
    protected IGenericRepository<Staff, UUID> getRepo() {
        return staffRepository;
    }

    //METHOD TO GET THE ROLE NAME BY ID
    /*public String consultRole(String idRole) {
        String url = "http://user-service/api/v1/users/" + idRole;

        RoleDTO role = apiAdapter.get(url, null, RoleDTO.class);
        return role.getName();
    }*/
}
