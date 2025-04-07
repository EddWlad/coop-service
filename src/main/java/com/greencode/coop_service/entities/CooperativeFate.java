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
@IdClass(CooperativeFatePK.class)
public class CooperativeFate {
    @Id
    private Cooperative cooperative;

    @Id
    private Fate fate;

    private Integer status = 1;
}
