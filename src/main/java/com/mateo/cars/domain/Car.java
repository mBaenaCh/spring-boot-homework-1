package com.mateo.cars.domain;

import jdk.vm.ci.meta.Local;

import java.time.LocalDate;
import java.util.Objects;

public class Car {
    /* Para validar el uso de mis modelos del dominio debere añadir clases validadoras por cada
    *  parametro sobre el cual desee realizar validaciones, estas clases hacen referencia a
    *  Value Objects que de forma unitaria representan un objeto totalmente nuevo frente al cambio.
    *
    *  Recordemos que Car en este caso es un objeto entidad porque, a pesar de que, si cambiamos alguno de
    *  sus parametros, este objeto seguira siendo el mismo y estos cambios no retornaran uno nuevo.
    *
    *  En el caso de la propiedad dateOfProduction:
    *   - Lo renombraremos y le asignaremos otro tipo de variable para usar correctamente las fechas en Java
    *   - Usaremos un objeto LocalDate de tipo Date para mapear una fecha en formato YYYY-MM-DD
    *   - Validaremos que este no sea vacio
     */

    private final CarId id;
    private final CarBrand brand;
    private final CarModel model;
    private final LocalDate dateOfProduction;
    private final CarColor color;

    public Car(CarId id, CarBrand brand, CarModel model, LocalDate dateOfProduction, CarColor color) {
        Objects.requireNonNull(id, "The car id must not be an empty value");
        Objects.requireNonNull(brand, "The car brand name must not be an empty value");
        Objects.requireNonNull(model, "The car model name must not be an empty value");
        Objects.requireNonNull(dateOfProduction, "The date of production must not be an empty value");
        Objects.requireNonNull(color, "The car color name must not be an empty value");
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.dateOfProduction = dateOfProduction;
        this.color = color;
    }

    public CarId getId() {
        return id;
    }

    public CarBrand getBrand() {
        return brand;
    }

    public CarModel getModel() {
        return model;
    }

    public LocalDate getYearOfProduction() {
        return dateOfProduction;
    }

    public CarColor getColor() {
        return color;
    }


    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", dateOfProduction=" + dateOfProduction +
                ", color='" + color + '\'' +
                '}';
    }
}