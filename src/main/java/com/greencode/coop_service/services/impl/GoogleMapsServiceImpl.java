package com.greencode.coop_service.services.impl;

import com.greencode.coop_service.dtos.GoogleDirectionsResponseDTO;
import com.greencode.coop_service.services.IGoogleMapsService;
import com.greencode.coop_service.utils.ApiAdapter;
import org.springframework.beans.factory.annotation.Value;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class GoogleMapsServiceImpl implements IGoogleMapsService {
    private final ApiAdapter apiAdapter;

    @Value("${google.maps.api-key}")
    private String apiKey;
    private static final String BASE_URL = "https://maps.googleapis.com";
    @Override
    public GoogleDirectionsResponseDTO getRoute(String origin, String destination) throws Exception {
        String endpoint = "/maps/api/directions/json";

        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("origin", origin);
        queryParams.put("destination", destination);
        queryParams.put("key", apiKey);

        return apiAdapter.get(BASE_URL + endpoint, queryParams, GoogleDirectionsResponseDTO.class);
    }
}
