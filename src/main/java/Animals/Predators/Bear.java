package Animals.Predators;

import AnimalFactory.AnimalType;
import AnimalFactory.Gender;
import Animals.Predator;
import Island.Cell;

public class Bear extends Predator {
    public Bear(double weight, int maxCellPopulation, int speed, double maxSaturation, Cell cell,
                int offspring, Gender gender, double saturation, int daysBeforeDecay) {
        super(weight, maxCellPopulation, speed, maxSaturation, cell, offspring, gender, saturation, daysBeforeDecay);
    }

    public AnimalType getAnimalType(){
        return AnimalType.BEAR;
    }

}
