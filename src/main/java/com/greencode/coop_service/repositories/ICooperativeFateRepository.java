package com.greencode.coop_service.repositories;

import com.greencode.coop_service.entities.CooperativeFate;
import com.greencode.coop_service.entities.CooperativeFatePK;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.UUID;

@Repository
public interface ICooperativeFateRepository extends IGenericRepository<CooperativeFate, CooperativeFatePK>{

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO cooperative_fate(id_coop, id_fate, status) VALUES(:idCoop, :idFate, 1)", nativeQuery = true)
    Integer saveTransactional(@Param("idCoop")UUID idCoop, @Param("idFate")UUID idFate);

}
