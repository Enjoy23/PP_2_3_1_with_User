package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.Car;
import web.service.CarService;

@Controller
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping()
    public String getCar(@RequestParam(defaultValue = "5") int count, Model model) {
        model.addAttribute("cars",carService.getCars(count));
        return "carsIndex";
    }
    @GetMapping(value = "/new")
    public String newCar(Model model) {
        model.addAttribute("car",new Car());
        return "new";
    }
    @PostMapping
    public String addNewCar(@ModelAttribute("car") Car car){
        carService.addNewCar(car);
        return "redirect:/carsIndex";
    }
}
