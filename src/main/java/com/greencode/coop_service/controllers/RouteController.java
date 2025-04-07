package com.greencode.coop_service.controllers;

import com.greencode.coop_service.dtos.RouteDTO;
import com.greencode.coop_service.entities.Route;
import com.greencode.coop_service.services.IRouteService;
import com.greencode.coop_service.utils.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/routes")
@RequiredArgsConstructor
public class RouteController {
    private final IRouteService routeService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<RouteDTO>> findAll() throws Exception{
        List<RouteDTO> list = mapperUtil.mapList(routeService.findAll(), RouteDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RouteDTO> findById(@PathVariable("id") String id) throws Exception{
        RouteDTO RouteDTO = mapperUtil.map(routeService.findById(UUID.fromString(id)), RouteDTO.class);
        return ResponseEntity.ok(RouteDTO);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody RouteDTO RouteDTO) throws Exception{
        Route obj = routeService.save(mapperUtil.map(RouteDTO, Route.class));

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getIdRoute())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<RouteDTO> update(@PathVariable("id") String id, @RequestBody RouteDTO RouteDTO) throws Exception{
        Route obj = routeService.update(mapperUtil.map(RouteDTO, Route.class), UUID.fromString(id));
        return ResponseEntity.ok(mapperUtil.map(obj, RouteDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) throws Exception{
        routeService.delete(UUID.fromString(id));
        return ResponseEntity.noContent().build();
    }
}
