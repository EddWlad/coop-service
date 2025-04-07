package com.greencode.coop_service.controllers;

import com.greencode.coop_service.dtos.BusDTO;
import com.greencode.coop_service.entities.Bus;
import com.greencode.coop_service.services.IBusService;
import com.greencode.coop_service.utils.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/buses")
@RequiredArgsConstructor
public class BusController {

    private final IBusService busService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<BusDTO>> findAll() throws Exception{
        List<BusDTO> list = mapperUtil.mapList(busService.findAll(), BusDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BusDTO> findById(@PathVariable("id") String id) throws Exception{
        BusDTO busDTO = mapperUtil.map(busService.findById(UUID.fromString(id)), BusDTO.class);
        return ResponseEntity.ok(busDTO);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody BusDTO busDTO) throws Exception{
        Bus obj = busService.save(mapperUtil.map(busDTO, Bus.class));

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getIdBus())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<BusDTO> update(@PathVariable("id") String id, @RequestBody BusDTO busDTO) throws Exception{
        Bus obj = busService.update(mapperUtil.map(busDTO, Bus.class), UUID.fromString(id));
        return ResponseEntity.ok(mapperUtil.map(obj, BusDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) throws Exception{
        busService.delete(UUID.fromString(id));
        return ResponseEntity.noContent().build();
    }
}
