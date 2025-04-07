package com.greencode.coop_service.services.impl;

import com.greencode.coop_service.entities.Route;
import com.greencode.coop_service.repositories.IGenericRepository;
import com.greencode.coop_service.repositories.IRouteRepository;
import com.greencode.coop_service.services.ICityService;
import com.greencode.coop_service.services.IGoogleMapsService;
import com.greencode.coop_service.services.IRouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RouteServiceImpl extends GenericServiceImpl<Route, UUID> implements IRouteService {
    private final IRouteRepository routeRepository;
    private final ICityService cityService;
    private final IGoogleMapsService googleMapsService;


    @Override
    protected IGenericRepository<Route, UUID> getRepo() {
        return routeRepository;
    }

    @Override
    public Route save(Route route) throws Exception {
        // 1. Obtener objetos ciudad completos
        var originCity = cityService.findById(route.getOriginCityId());
        var destinationCity = cityService.findById(route.getDestinationCityId());

        // 2. Construir nombre completo: "Quito, Ecuador"
        String origin = originCity.getName() + ", " + originCity.getCountry();
        String destination = destinationCity.getName() + ", " + destinationCity.getCountry();

        // 3. Llamar a Google Maps
        var response = googleMapsService.getRoute(origin, destination);

        if (response != null && !response.getRoutes().isEmpty()) {
            var routeData = response.getRoutes().get(0);
            var leg = routeData.getLegs().get(0);

            route.setDistanceKm(leg.getDistance().getValue() / 1000.0);
            route.setMapPath(routeData.getOverview_polyline().getPoints());
        }

        if (route.getMapPath() == null) {
            throw new RuntimeException("Error: No se pudo obtener la ruta desde Google Maps.");
        }

        return super.save(route);
    }
}
