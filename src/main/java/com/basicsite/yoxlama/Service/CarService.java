package com.basicsite.yoxlama.Service;

import com.basicsite.yoxlama.Entity.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {

     Car saveCar(Car car);
     List<Car> getAllCar();
     Car getCarById(Long id);

     Car updateCar(Long id, Car car);

     void deleteCar(Long id);


}
