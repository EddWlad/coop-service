package com.greencode.coop_service.repositories;

import com.greencode.coop_service.entities.FatePrice;
import com.greencode.coop_service.entities.FatePricePK;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Repository
public interface IFatePriceRepository extends IGenericRepository<FatePrice, FatePricePK> {

    @Transactional
    @Modifying
    @Query(value ="INSERT INTO fate_price (id_price, id_fate, status) VALUES(:idPrice, :idFate, 1)", nativeQuery = true)
    Integer saveTransactional(@Param("idPrice")UUID idPrice, @Param("idFate")UUID idFate);

}
