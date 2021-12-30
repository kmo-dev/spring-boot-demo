package kmo.spring.demo.data.repository;

import kmo.spring.demo.data.entity.Car;
import kmo.spring.demo.data.entity.VinOnly;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "car", collectionResourceRel = "car", excerptProjection = VinOnly.class)
public interface CarRepository extends JpaRepository<Car, String> {

    /**
     * Example queries:
     * http://localhost:8888/car/search/color?color=green&sort=vin,desc
     */
    @RestResource(path = "color", rel = "color")
    Page<Car> findAllByColorEquals(@Param("color") final String color, final Pageable pageable);

    /**
     * Example queries:
     * http://localhost:8888/car/search/owner?owner=klemi&sort=vin,asc
     */
    @Query("select c from Car c where c.owner = :owner")
    @RestResource(path = "owner", rel = "owner")
    Page<Car> customQuery(@Param("owner") final String owner, final Pageable pageable);

}
