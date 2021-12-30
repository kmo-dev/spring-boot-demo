package kmo.spring.demo.data.entity;

import org.springframework.data.rest.core.config.Projection;

/**
 * Example queries:
 * http://localhost:8888/car/vin1?projection=vinOnly
 */
@Projection(name = "vinOnly", types = {Car.class})
public interface VinOnly {
    String getVin();
}