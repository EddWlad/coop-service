package com.greencode.coop_service.controllers;

import com.greencode.coop_service.dtos.LicenseDTO;
import com.greencode.coop_service.entities.License;
import com.greencode.coop_service.services.ILicenseService;
import com.greencode.coop_service.utils.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/licenses")
@RequiredArgsConstructor
public class LicenseController {

    private final ILicenseService licenseService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<LicenseDTO>> findAll() throws Exception{
        List<LicenseDTO> list = mapperUtil.mapList(licenseService.findAll(), LicenseDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LicenseDTO> findById(@PathVariable("id") String id) throws Exception{
        LicenseDTO LicenseDTO = mapperUtil.map(licenseService.findById(UUID.fromString(id)), LicenseDTO.class);
        return ResponseEntity.ok(LicenseDTO);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody LicenseDTO LicenseDTO) throws Exception{
        License obj = licenseService.save(mapperUtil.map(LicenseDTO, License.class));

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getIdLicense())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<LicenseDTO> update(@PathVariable("id") String id, @RequestBody LicenseDTO LicenseDTO) throws Exception{
        License obj = licenseService.update(mapperUtil.map(LicenseDTO, License.class), UUID.fromString(id));
        return ResponseEntity.ok(mapperUtil.map(obj, LicenseDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) throws Exception{
        licenseService.delete(UUID.fromString(id));
        return ResponseEntity.noContent().build();
    }
}
