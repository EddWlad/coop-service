package com.greencode.coop_service.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CooperativeListFateDTO {
    private CooperativeDTO cooperative;
    private List<FateDTO> fates;
}
