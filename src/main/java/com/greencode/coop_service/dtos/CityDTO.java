package com.greencode.coop_service.dtos;

import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CityDTO {
    @EqualsAndHashCode.Include
    private UUID idCity;

    private String name;
    private String province;
    private String country;
    private Integer status = 1;
}
