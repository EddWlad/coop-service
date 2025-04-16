package com.greencode.coop_service.dtos;

import com.fasterxml.jackson.annotation.JsonBackReference;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class BusDTO {
    @EqualsAndHashCode.Include
    private UUID idBus;

    private String type;
    private Integer unitNumber;
    private Integer seatsNumber;
    private String plate;
    private Integer status = 1;

    @JsonManagedReference
    //@JsonBackReference
    private CooperativeDTO cooperative;

    private List<StaffDTO> staff;

}
