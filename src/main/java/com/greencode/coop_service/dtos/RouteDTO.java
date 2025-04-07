package com.greencode.coop_service.dtos;

import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class RouteDTO {
    @EqualsAndHashCode.Include
    private UUID idRoute;

    private UUID originCityId;
    private UUID destinationCityId;

    private String mapPath;
    private Double distanceKm;
    private Integer status = 1;
}
