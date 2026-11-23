package com.dmp.external;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Placeholder client for external emergency service gateways (ambulance dispatch,
 * fire department, police SOS relays).
 */
@Component
public class EmergencyServicesClient {

    @Value("${external.emergency.api-key:}")
    private String apiKey;

    public void dispatchAmbulance(Long sosRequestId) {
        // TODO: call the configured emergency services gateway.
        throw new UnsupportedOperationException("Emergency services integration not yet implemented");
    }
}
