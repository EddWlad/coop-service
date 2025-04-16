package com.greencode.coop_service.dtos;

import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class StaffDTO {
    @EqualsAndHashCode.Include
    private UUID idStaff;

    private String name;
    private String idRol;
    private String phone;
    private String email;
    private Integer status = 1;
    private LicenseDTO license;
    private BusDTO bus;

}
