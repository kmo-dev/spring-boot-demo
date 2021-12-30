package kmo.spring.demo.data.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CarRepositoryRestTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private CarRepository carRepository;

    @Test
    void whenGivenThen() throws Exception {
        mvc.perform(get("/car")
                        .contentType("application/hal+json"))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith("application/hal+json"));
    }
}