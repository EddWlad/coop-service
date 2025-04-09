package com.greencode.coop_service.controllers;

import com.greencode.coop_service.dtos.FateDTO;
import com.greencode.coop_service.dtos.FateListPriceDTO;
import com.greencode.coop_service.entities.Fate;
import com.greencode.coop_service.entities.Price;
import com.greencode.coop_service.services.IFateService;
import com.greencode.coop_service.utils.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/fates")
@RequiredArgsConstructor
public class FateController {
    private final IFateService fateService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<FateDTO>> findAll() throws Exception{
        List<FateDTO> list = mapperUtil.mapList(fateService.findAll(), FateDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FateDTO> findById(@PathVariable("id") String id) throws Exception{
        FateDTO FateDTO = mapperUtil.map(fateService.findById(UUID.fromString(id)), FateDTO.class);
        return ResponseEntity.ok(FateDTO);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody FateListPriceDTO dto) throws Exception{
        Fate obj1 = mapperUtil.map(dto.getFate(), Fate.class);
        List<Price> list = mapperUtil.mapList(dto.getPrices(), Price.class);

        Fate obj = fateService.saveTransactional(obj1, list);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getIdFate()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<FateDTO> update(@PathVariable("id") String id, @RequestBody FateDTO FateDTO) throws Exception{
        Fate obj = fateService.update(mapperUtil.map(FateDTO, Fate.class), UUID.fromString(id));
        return ResponseEntity.ok(mapperUtil.map(obj, FateDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) throws Exception{
        fateService.delete(UUID.fromString(id));
        return ResponseEntity.noContent().build();
    }
}
