package com.dmp.external;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Placeholder client for a weather provider (OpenWeatherMap, etc.).
 * Used for: heavy rainfall alerts, forecasts, weather-based safety tips.
 */
@Component
public class WeatherClient {

    @Value("${external.weather.api-key:}")
    private String apiKey;

    public Object getForecast(double lat, double lng) {
        // TODO: call the configured weather provider's API.
        throw new UnsupportedOperationException("Weather integration not yet implemented");
    }
}
