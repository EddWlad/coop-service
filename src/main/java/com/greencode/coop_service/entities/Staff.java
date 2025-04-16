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
@Table(name= "staff")
public class Staff {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false, columnDefinition = "uuid")
    @EqualsAndHashCode.Include
    private UUID idStaff;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "idRol", nullable = false)
    private String idRol;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(nullable = false)
    private Integer status = 1;

    @ManyToOne
    @JoinColumn(name = "id_license", foreignKey = @ForeignKey(name = "FK_LICENSE"))
    private License license;

    @ManyToOne
    @JoinColumn(name = "id_bus", foreignKey = @ForeignKey(name = "FK_BUS"))
    private Bus bus;

}
