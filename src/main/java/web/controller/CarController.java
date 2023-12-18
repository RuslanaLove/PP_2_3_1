package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.servise.CarService;

@Controller
public class CarController {

    private CarService carServise;

    @Autowired
    public CarController(CarService carService) {
        this.carServise = carService;
    }

    @GetMapping("/cars")
    public String listIndexCars(@RequestParam(value = "count", defaultValue = "5") int count, ModelMap model) {
        if(count >= 5) {
            model.addAttribute("cars", carServise.listCars(carServise.countCars()));
        } else {
            model.addAttribute("cars", carServise.listCars(count));
        }
        return "cars";
    }
}
