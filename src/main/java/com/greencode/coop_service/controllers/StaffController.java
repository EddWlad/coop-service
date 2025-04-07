package com.greencode.coop_service.controllers;

import com.greencode.coop_service.dtos.StaffDTO;
import com.greencode.coop_service.entities.Staff;
import com.greencode.coop_service.utils.MapperUtil;
import lombok.RequiredArgsConstructor;
import com.greencode.coop_service.services.IStaffService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/staffs")
@RequiredArgsConstructor
public class StaffController {
    private final IStaffService staffService;
    private final MapperUtil mapperUtil;
    
    @GetMapping
    public ResponseEntity<List<StaffDTO>> findAll() throws Exception{
        List<StaffDTO> list = mapperUtil.mapList(staffService.findAll(), StaffDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StaffDTO> findById(@PathVariable("id") String id) throws Exception{
        StaffDTO StaffDTO = mapperUtil.map(staffService.findById(UUID.fromString(id)), StaffDTO.class);
        return ResponseEntity.ok(StaffDTO);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody StaffDTO StaffDTO) throws Exception{
        Staff obj = staffService.save(mapperUtil.map(StaffDTO, Staff.class));

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getIdStaff())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<StaffDTO> update(@PathVariable("id") String id, @RequestBody StaffDTO StaffDTO) throws Exception{
        Staff obj = staffService.update(mapperUtil.map(StaffDTO, Staff.class), UUID.fromString(id));
        return ResponseEntity.ok(mapperUtil.map(obj, StaffDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) throws Exception{
        staffService.delete(UUID.fromString(id));
        return ResponseEntity.noContent().build();
    }
}
