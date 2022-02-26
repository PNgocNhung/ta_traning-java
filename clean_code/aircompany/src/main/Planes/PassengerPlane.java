package com.epam.trainning.ngocnhung.clean_code.aircompany.src.main.Planes;

import java.util.Objects;

public class PassengerPlane extends Plane {

    private int passengersCapacity;


    public PassengerPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, int passengersCapacity) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.passengersCapacity = passengersCapacity;
    }

    public  void setPassengersCapacity (int passengersCapacity) {
        this.passengersCapacity = passengersCapacity;
    }

    public int getPassengersCapacity() {
        return passengersCapacity;
    }


    @Override
    public String toString() {
        return super.toString().replace("}", ", passengersCapacity=" + passengersCapacity + '}');
    }


    @Override
    public boolean equals(Object o) {
        if (o instanceof PassengerPlane) {
            PassengerPlane passengerPlane = (PassengerPlane) o;
            return (super.equals(o) && passengersCapacity == passengerPlane.passengersCapacity);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), passengersCapacity);
    }
}
