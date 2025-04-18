package com.greencode.coop_service.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name= "bus")
public class Bus {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false, columnDefinition = "uuid")
    @EqualsAndHashCode.Include
    private UUID idBus;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "unitNumber", nullable = false)
    private Integer unitNumber;

    @Column(name = "seatsNumber", nullable = false)
    private Integer seatsNumber;

    @Column(name = "plate", unique = true, nullable = false)
    private String plate;

    @Column(nullable = false)
    private Integer status = 1;

    @ManyToOne
    @JoinColumn(name = "id_coop", foreignKey = @ForeignKey(name = "FK_COOPERATIVE"))
    private Cooperative cooperative;

    @OneToMany(mappedBy = "bus", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Staff> staffs;

    /*@ManyToOne
    @JoinColumn(name = "id_staff", foreignKey = @ForeignKey(name = "FK_STAFF"))
    private Staff staff;*/

}
