package kmo.spring.demo.data.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

/**
 * Example queries:
 * http://localhost:8888/car/vin1?projection=noOwner
 */
@Projection(name = "noOwner", types = {Car.class})
public interface NoOwner {
    String getVin();

    String getColor();

    @Value("#{target.vin} has the color #{target.color}.")
    String getMessage();
}