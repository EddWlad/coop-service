package com.greencode.coop_service.dtos;

import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class LicenseDTO {
    @EqualsAndHashCode.Include
    private UUID idLicense;

    private String type;
    private String description;
    private Integer status = 1;
}
