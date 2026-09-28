package com.basicsite.yoxlama.Repository;

import com.basicsite.yoxlama.Entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {

}
