package com.greencode.coop_service.services.impl;

import com.greencode.coop_service.entities.City;
import com.greencode.coop_service.entities.Fate;
import com.greencode.coop_service.entities.Price;
import com.greencode.coop_service.entities.Route;
import com.greencode.coop_service.repositories.*;
import com.greencode.coop_service.services.IFateService;
import com.greencode.coop_service.services.IPriceService;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FateServiceImpl extends GenericServiceImpl<Fate, UUID> implements IFateService {
    private final IFateRepository fateRepository;
    private final IFatePriceRepository fpRepo;
    private final ICityRepository cityRepository;
    private final IRouteRepository routeRepository;
    private final IPriceService priceService;


    @Override
    @Transactional
    public Fate saveTransactional(Fate fate, List<Price> prices) throws Exception {
        if(fate.getCity() != null && fate.getCity().getIdCity() != null) {
            City city = cityRepository.findById(fate.getCity()
                    .getIdCity())
                    .orElseThrow(() ->
                         new RuntimeException("City not found ID: " + fate.getCity().getIdCity()));
            fate.setCity(city);
        } else if (fate.getRoute() != null && fate.getRoute().getIdRoute() != null) {
            Route route = routeRepository.findById(fate.getRoute()
                    .getIdRoute())
                    .orElseThrow(() ->
                         new RuntimeException("Route not found ID: " + fate.getRoute().getIdRoute()));
            fate.setRoute(route);
        }
        fateRepository.save(fate);
        for (Price p : prices) {
            Price savedPrice = priceService.save(p);
            fpRepo.saveTransactional(fate.getIdFate(), savedPrice.getIdPrice());
        }

        return fate;
    }

    @Override
    @Transactional
    protected IGenericRepository<Fate, UUID> getRepo() {
        return fateRepository;
    }
}
