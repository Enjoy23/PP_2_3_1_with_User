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
    public String getAllCars(Model model) {
        model.addAttribute("cars",carService.getCars());
        return "carsIndex";
    }
    @GetMapping(value = "/new")
    public String createNewCar(Model model) {
        model.addAttribute("car",new Car());
        return "new";
    }
    @PostMapping
    public String addNewCar(@ModelAttribute("car") Car car){
        carService.addNewCar(car);
        return "redirect:/cars";
    }

    @PostMapping(value = "/{id}/delete")
    public String delete(@PathVariable("id") long id) {
        carService.deleteCar(id);
        return "redirect:/cars";
    }

    @GetMapping("/edit/{id}/")
    public String editUserForm(@PathVariable("id") long id, ModelMap model) {
        model.addAttribute("car", carService.findCarById(id));
        return "edit_car";
    }

    @PostMapping("/edit")
    public String updateUserInfo(@ModelAttribute("user") Car car) {
        System.out.println(car);
        carService.updateCar(car);
        return "redirect:/cars";
    }

}
