package com.greencode.coop_service.dtos;

import lombok.Data;

import java.util.List;

@Data
public class GoogleDirectionsResponseDTO {
    private List<Route> routes;

    @Data
    public static class Route {
        private OverviewPolyline overview_polyline;
        private List<Leg> legs;
    }

    @Data
    public static class OverviewPolyline {
        private String points;
    }

    @Data
    public static class Leg {
        private Distance distance;
        private Duration duration;
    }

    @Data
    public static class Distance {
        private String text;
        private int value;
    }

    @Data
    public static class Duration {
        private String text;
        private int value;
    }
}