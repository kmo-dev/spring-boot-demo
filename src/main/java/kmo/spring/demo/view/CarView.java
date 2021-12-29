package kmo.spring.demo.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import kmo.spring.demo.data.entity.Car;
import kmo.spring.demo.data.repository.CarRepository;


@Route("carview")
public class CarView extends FormLayout {

    public CarView(final CarRepository carRepository) {
        final var vin = new TextField("vin");
        final var color = new TextField("color");
        final var owner = new TextField("owner");

        final var hr = new Hr();

        final var submit = new Button("submit");
        this.add(vin, color, owner, submit, hr);
        this.setResponsiveSteps(
                new ResponsiveStep("0", 1),
                new ResponsiveStep("500px", 2));

        this.setColspan(vin, 2);
        this.setColspan(hr, 2);

        final var cars = new Grid<>(Car.class, true);
        cars.setItems(carRepository.findAll());
        this.add(cars);

        submit.addClickListener(e -> carRepository.save(new Car(vin.getValue(), color.getValue(), owner.getValue())));
        submit.addClickListener(e -> {
            vin.clear();
            color.clear();
            owner.clear();
            cars.setItems(carRepository.findAll());
        });


    }
}
