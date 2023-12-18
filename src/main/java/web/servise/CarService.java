package web.servise;

import web.model.Car;

import java.util.List;

public interface CarService {

    List<Car> listCars(int count);

    int countCars();
}
