package com.epam.trainning.ngocnhung.clean_code.aircompany.src.main.Planes;

import com.epam.trainning.ngocnhung.clean_code.aircompany.src.main.models.MilitaryType;

import java.util.Objects;

public class MilitaryPlane extends Plane {

    private MilitaryType type;

    public MilitaryPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, MilitaryType type) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.type = type;
    }

    public void setType(MilitaryType type) {
        this.type = type;
    }

    public MilitaryType getType() {
        return type;
    }


    @Override
    public String toString() {
        return super.toString().replace("}", ", type=" + type + '}');
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof MilitaryPlane) {
            MilitaryPlane militaryPlane = (MilitaryPlane) o;
            return (super.equals(o) && type == militaryPlane.type);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type);
    }
}
