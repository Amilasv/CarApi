package com.basicsite.yoxlama.Controller;

import com.basicsite.yoxlama.Entity.Car;
import com.basicsite.yoxlama.Service.CarService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService){
        this.carService = carService;
    }

    @PostMapping("/addcar")
    public ResponseEntity<Car> Addcar(@Valid @RequestBody Car car){
        Car savedcar = carService.saveCar(car);
        return ResponseEntity.ok().body(savedcar);
    }

    @GetMapping("/allcars")
    public List<Car> getAllCar(){
        return carService.getAllCar();
    }

    @GetMapping("/{id}/getcarbyid")
    public ResponseEntity<Car> getCarById(@PathVariable Long id){
        return ResponseEntity.ok(carService.getCarById(id));


    }

    @PutMapping("/{id}/updatebyid")
    public Car updateCar(@PathVariable Long id,@Valid @RequestBody Car car){
        return carService.updateCar(id,car);
    }


    @DeleteMapping("/{id}/deletebyid")
    public void deleteCar(@PathVariable Long id){
        carService.deleteCar(id);
    }


}
