package com.dmp.external;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Placeholder client for a maps/routing provider (Google Maps, Mapbox, OpenStreetMap).
 * Used for: safe routes, affected zones, nearest shelter/hospital lookups.
 */
@Component
public class MapsClient {

    @Value("${external.maps.api-key:}")
    private String apiKey;

    public Object getSafeRoute(double fromLat, double fromLng, double toLat, double toLng) {
        // TODO: call the configured maps provider's directions API.
        throw new UnsupportedOperationException("Maps integration not yet implemented");
    }
}
