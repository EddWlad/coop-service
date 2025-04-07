package com.greencode.coop_service.dtos;

import com.fasterxml.jackson.annotation.JsonBackReference;


import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class BusDTO {
    @EqualsAndHashCode.Include
    private UUID idBus;

    private Integer type;
    private Integer unitNumber;
    private Integer seatsNumber;
    private String plate;
    private Integer status = 1;

    @JsonBackReference
    private CooperativeDTO cooperative;

    private StaffDTO staff;

}
