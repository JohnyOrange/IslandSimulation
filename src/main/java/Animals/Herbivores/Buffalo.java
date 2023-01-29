package Animals.Herbivores;

import AnimalFactory.AnimalType;
import AnimalFactory.Gender;
import Animals.Herbivore;
import Island.Cell;

public class Buffalo extends Herbivore {
    public Buffalo(double weight, int maxCellPopulation, int speed, double maxSaturation, Cell cell,
                   int offspring, Gender gender, double saturation, int daysBeforeDecay) {
        super(weight, maxCellPopulation, speed, maxSaturation, cell, offspring, gender, saturation, daysBeforeDecay);
    }

    public AnimalType getAnimalType(){
        return AnimalType.BUFFALO;
    }

}
