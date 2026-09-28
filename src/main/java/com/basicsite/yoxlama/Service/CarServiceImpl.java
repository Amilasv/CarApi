package com.basicsite.yoxlama.Service;

import com.basicsite.yoxlama.Entity.Car;
import com.basicsite.yoxlama.Exception.CarNotFoundException;
import com.basicsite.yoxlama.Repository.CarRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService{
    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository){
        this.carRepository = carRepository;
    }

    @Override
    public Car saveCar(Car car){
        return carRepository.save(car);
    }

    @Override
    public List<Car> getAllCar(){
        return carRepository.findAll();
    }

    @Override
    public Car getCarById(Long id) {
        return carRepository.findById(id).orElseThrow(() -> new CarNotFoundException("There is not any car with this id :" + id));
    }

    @Override
    public Car updateCar(Long id, Car car){
        Car existingsfieldsofcar = getCarById(id);
        existingsfieldsofcar.setBrand(car.getBrand());
        existingsfieldsofcar.setModel(car.getModel());
        existingsfieldsofcar.setYear(car.getYear());
        existingsfieldsofcar.setColor(car.getColor());
        existingsfieldsofcar.setPrice(car.getPrice());
        return carRepository.save(existingsfieldsofcar);

    }

    @Override
    public void deleteCar(Long id){
        if (!carRepository.existsById(id)){
            throw new CarNotFoundException("There is not any car with this id :" + id);
        }
        carRepository.deleteById(id);

    }
}
