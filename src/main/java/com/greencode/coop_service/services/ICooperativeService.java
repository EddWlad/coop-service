package com.greencode.coop_service.services;

import com.greencode.coop_service.entities.Cooperative;
import com.greencode.coop_service.entities.Fate;

import java.util.List;
import java.util.UUID;

public interface ICooperativeService extends IGenericService<Cooperative, UUID>{

    Cooperative saveTransactional(Cooperative cooperative, List<Fate> fates) throws Exception;
}
