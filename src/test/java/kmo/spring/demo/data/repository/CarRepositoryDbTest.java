package kmo.spring.demo.data.repository;

import kmo.spring.demo.data.entity.Car;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;

@DataJpaTest
class CarRepositoryDbTest {

    @Autowired
    private CarRepository underTest;

    @Test
    void whenGivenThen() {
        List<Car> result = underTest.findAll();

        assertThat(result, is(empty()));
    }
}