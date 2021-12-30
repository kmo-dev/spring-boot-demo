package kmo.spring.demo.data.entity;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Getter
@ToString
@Entity
public class Car {

    @Id
    private String vin;

    @NotBlank
    private String color;

    @NotBlank
    private String owner;

    private String email;

    protected Car() {
    }

    public Car(final String vin, final String color, final String owner, final String email) {
        this.vin = vin;
        this.color = color;
        this.owner = owner;
        this.email = email;
    }

}
