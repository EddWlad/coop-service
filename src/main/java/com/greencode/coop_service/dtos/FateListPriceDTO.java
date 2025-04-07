package com.greencode.coop_service.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FateListPriceDTO {
    private FateDTO fate;
    private List<PriceDTO> prices;
}
