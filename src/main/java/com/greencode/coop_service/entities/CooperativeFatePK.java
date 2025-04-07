package com.greencode.coop_service.entities;


import jakarta.persistence.Embeddable;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
public class CooperativeFatePK implements Serializable {
    @ManyToOne
    @JoinColumn(name = "id_coop", foreignKey = @ForeignKey(name = "FK_COOPERATIVE_FATE_C"))
    private Cooperative cooperative;

    @ManyToOne
    @JoinColumn(name = "id_fate", foreignKey = @ForeignKey(name = "FK_COOPERATIVE_FATE_F"))
    private Fate fate;
}
