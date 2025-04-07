package com.greencode.coop_service.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(FatePricePK.class)
public class FatePrice {
    @Id
    private Fate fate;

    @Id
    private Price price;

    private Integer status = 1;
}
