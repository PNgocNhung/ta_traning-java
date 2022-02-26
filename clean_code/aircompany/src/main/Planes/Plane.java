package com.epam.trainning.ngocnhung.clean_code.aircompany.src.main.Planes;

import java.util.Objects;

abstract public class Plane {
    String model;
    private  int maxSpeed;
    private  int maxFlightDistance;
    private  int maxLoadCapacity;

    public Plane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity) {
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.maxFlightDistance = maxFlightDistance;
        this.maxLoadCapacity = maxLoadCapacity;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setMaxSpeed(int maxSpeed) {this.maxSpeed = maxSpeed;}

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxFlightDistance(int maxFlightDistance) {
        this.maxFlightDistance = maxFlightDistance;
    }
    public int getMaxFlightDistance() {
        return maxFlightDistance;
    }

    public void setMaxLoadCapacity(int maxLoadCapacity) {
        this.maxLoadCapacity = maxLoadCapacity;
    }
    public int getMaxLoadCapacity() {return maxLoadCapacity;}

    @Override
    public String toString() {
        return "Plane{" + "model='" + model +
                '\'' + ", maxSpeed=" + maxSpeed +
                ", maxFlightDistance=" + maxFlightDistance +
                ", maxLoadCapacity=" + maxLoadCapacity + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (o instanceof Plane) {
            Plane plane = (Plane) o;
            return plane.maxSpeed == maxSpeed &&
                    plane.maxFlightDistance == maxFlightDistance &&
                    plane.maxLoadCapacity == maxLoadCapacity &&
                   Objects.equals(plane.model,model);
        }
        return false;
    }


    @Override
    public int hashCode() {
        return Objects.hash(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
    }
}
