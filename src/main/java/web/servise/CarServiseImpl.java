package web.servise;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class CarServiseImpl implements CarService {

    private List<Car> cars;

    {
        cars = new ArrayList<>();

        cars.add(new Car(1, "audi", "black"));
        cars.add(new Car(2,"bmw", "red"));
        cars.add(new Car(3,"toyota", "blue"));
        cars.add(new Car(4,"hyundai", "green"));
        cars.add(new Car(5,"honda", "white"));

    }

    @Override
    public List<Car> listCars(int count) {
        return cars.stream().limit(count).toList();
    }

    @Override
    public int countCars() {
        return cars.size();
    }
}
