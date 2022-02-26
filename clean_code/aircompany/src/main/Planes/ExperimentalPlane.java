package com.epam.trainning.ngocnhung.clean_code.aircompany.src.main.Planes;

import com.epam.trainning.ngocnhung.clean_code.aircompany.src.main.models.ClassificationLevel;
import com.epam.trainning.ngocnhung.clean_code.aircompany.src.main.models.ExperimentalTypes;

import java.util.Objects;

public class ExperimentalPlane extends Plane {

    private ExperimentalTypes type;
    private ClassificationLevel classificationLevel;

    public ExperimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, ExperimentalTypes type, ClassificationLevel classificationLevel) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.type = type;
        this.classificationLevel = classificationLevel;
    }

    public void setClassificationLevel(ClassificationLevel classificationLevel) {
        this.classificationLevel = classificationLevel;
    }

    public ClassificationLevel getClassificationLevel() {
        return classificationLevel;
    }

    public void setType(ExperimentalTypes type) {
        this.type = type;
    }

    public ExperimentalTypes getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof ExperimentalPlane) {
            ExperimentalPlane experimentalPlane = (ExperimentalPlane) o;
            return (super.equals(o) && type == experimentalPlane.type && classificationLevel == experimentalPlane.classificationLevel);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type, classificationLevel);
    }

    @Override
    public String toString() {
        return "experimentalPlane{" + "model='" + model + '\'' + '}';
    }
}
