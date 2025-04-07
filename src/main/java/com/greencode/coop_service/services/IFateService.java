package com.greencode.coop_service.services;

import com.greencode.coop_service.entities.Fate;
import com.greencode.coop_service.entities.Price;

import java.util.List;
import java.util.UUID;

public interface IFateService extends IGenericService<Fate, UUID>{
    Fate saveTransactional(Fate fate, List<Price> prices) throws Exception;
}
