package com.greencode.coop_service.controllers;

import com.greencode.coop_service.dtos.CooperativeDTO;
import com.greencode.coop_service.dtos.CooperativeListFateDTO;
import com.greencode.coop_service.entities.Cooperative;
import com.greencode.coop_service.entities.Fate;
import com.greencode.coop_service.services.ICooperativeService;
import com.greencode.coop_service.utils.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cooperatives")
@RequiredArgsConstructor
public class CooperativeController {
    
    private final ICooperativeService cooperativeService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<CooperativeDTO>> findAll() throws Exception{
        List<CooperativeDTO> list = mapperUtil.mapList(cooperativeService.findAll(), CooperativeDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CooperativeDTO> findById(@PathVariable("id") String id) throws Exception{
        CooperativeDTO CooperativeDTO = mapperUtil.map(cooperativeService.findById(UUID.fromString(id)), CooperativeDTO.class);
        return ResponseEntity.ok(CooperativeDTO);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody CooperativeListFateDTO dto) throws Exception{
        Cooperative obj1 = mapperUtil.map(dto.getCooperative(), Cooperative.class);
        List<Fate> list = mapperUtil.mapList(dto.getFates(), Fate.class);

        Cooperative obj = cooperativeService.saveTransactional(obj1, list);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getIdCoop()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CooperativeDTO> update(@PathVariable("id") String id, @RequestBody CooperativeDTO CooperativeDTO) throws Exception{
        Cooperative obj = cooperativeService.update(mapperUtil.map(CooperativeDTO, Cooperative.class), UUID.fromString(id));
        return ResponseEntity.ok(mapperUtil.map(obj, CooperativeDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) throws Exception{
        cooperativeService.delete(UUID.fromString(id));
        return ResponseEntity.noContent().build();
    }
    
}
