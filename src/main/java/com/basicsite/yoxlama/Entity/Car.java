package com.basicsite.yoxlama.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;


@Entity
@Table(name = "Car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "You cant left this place empty ")
    @Size(min = 2, max = 30,message = "Daxil edilen deyer 2-30 arasi olmalidir")
    @Column(name = "Car_Brand" , nullable = false )
    private String Brand;


    @NotBlank(message = "This place cannot be left empty.")
    @Column(name = "Car_Model" , nullable = false )
    private String Model;


    @PastOrPresent
    @NotNull(message = "This place cannot be left empty." )
    @Column(name = "Year" , nullable = false )
    private LocalDate Year;

    @Positive
    @NotNull(message = "This place cannot be left empty.")
    @Column(name = "car_price", nullable = false)
    private  int Price;

    @NotBlank
    @Column(name = "car_color", nullable = false)
    private String Color;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public LocalDate getYear() {
        return Year;
    }

    public void setYear(LocalDate year) {
        Year = year;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }
}
