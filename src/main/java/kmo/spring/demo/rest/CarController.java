package kmo.spring.demo.rest;

import kmo.spring.demo.data.entity.Car;
import kmo.spring.demo.data.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("rest-car")
@RequiredArgsConstructor
public class CarController {

    private final CarRepository carRepository;

    @GetMapping
    public ResponseEntity<String> get() {
        final var vins = carRepository.findAll().stream().map(Car::getVin).collect(Collectors.joining(","));
        return ResponseEntity.ok(vins);
    }

    @GetMapping("{vin}")
    public ResponseEntity<Car> get(@PathVariable final String vin) {
        return ResponseEntity.of(carRepository.findById(vin));
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody final Car car) {
        carRepository.save(car);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{vin}")
    public ResponseEntity<Car> delete(@PathVariable final String vin) {
        carRepository.deleteById(vin);
        return ResponseEntity.noContent().build();
    }
}
