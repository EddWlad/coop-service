package com.greencode.coop_service.services;

import com.greencode.coop_service.dtos.GoogleDirectionsResponseDTO;

public interface IGoogleMapsService{

    GoogleDirectionsResponseDTO getRoute(String origin, String destination) throws Exception;
}
