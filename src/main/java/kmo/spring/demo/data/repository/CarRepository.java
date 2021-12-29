package kmo.spring.demo.data.repository;

import kmo.spring.demo.data.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "car", collectionResourceRel = "car")
public interface CarRepository extends JpaRepository<Car, String> {
}
