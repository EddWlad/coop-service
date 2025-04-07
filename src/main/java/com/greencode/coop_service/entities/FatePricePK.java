package com.greencode.coop_service.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
public class FatePricePK implements Serializable {
    @ManyToOne
    @JoinColumn(name = "id_fate", foreignKey = @ForeignKey(name = "FK_FATE_PRICE_F"))
    private Fate fate;

    @ManyToOne
    @JoinColumn(name = "id_price", foreignKey = @ForeignKey(name = "FK_FATE_PRICE_P"))
    private Price price;
}
