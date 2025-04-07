package com.greencode.coop_service.controllers;

import com.greencode.coop_service.dtos.CityDTO;
import com.greencode.coop_service.entities.City;
import com.greencode.coop_service.services.ICityService;
import com.greencode.coop_service.utils.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cities")
@RequiredArgsConstructor
public class CityController {
    private final ICityService cityService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<CityDTO>> findAll() throws Exception{
        List<CityDTO> list = mapperUtil.mapList(cityService.findAll(), CityDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CityDTO> findById(@PathVariable("id") String id) throws Exception{
        CityDTO CityDTO = mapperUtil.map(cityService.findById(UUID.fromString(id)), CityDTO.class);
        return ResponseEntity.ok(CityDTO);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody CityDTO CityDTO) throws Exception{
        City obj = cityService.save(mapperUtil.map(CityDTO, City.class));

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getIdCity())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CityDTO> update(@PathVariable("id") String id, @RequestBody CityDTO CityDTO) throws Exception{
        City obj = cityService.update(mapperUtil.map(CityDTO, City.class), UUID.fromString(id));
        return ResponseEntity.ok(mapperUtil.map(obj, CityDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) throws Exception{
        cityService.delete(UUID.fromString(id));
        return ResponseEntity.noContent().build();
    }
}
