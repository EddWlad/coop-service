package com.greencode.coop_service.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name= "route")
public class Route {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false, columnDefinition = "uuid")
    @EqualsAndHashCode.Include
    private UUID idRoute;

    @Column(name = "originCityId", nullable = false, columnDefinition = "uuid")
    private UUID originCityId;

    @Column(name = "destinationCityId", nullable = false, columnDefinition = "uuid")
    private UUID destinationCityId;

    @Column(name = "mapPath", nullable = false, columnDefinition = "TEXT")
    private String mapPath;

    @Column(name = "distanceKm")
    private Double distanceKm;

    @Column(nullable = false)
    private Integer status = 1;
}
