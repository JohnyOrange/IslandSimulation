package Animals.Herbivores;

import AnimalFactory.AnimalType;
import AnimalFactory.Gender;
import Animals.Herbivore;
import Island.Cell;

public class Deer extends Herbivore {
    public Deer(double weight, int maxCellPopulation, int speed, double maxSaturation, Cell cell,
                int offspring, Gender gender, double saturation, int daysBeforeDecay) {
        super(weight, maxCellPopulation, speed, maxSaturation, cell, offspring, gender, saturation, daysBeforeDecay);
    }

    public AnimalType getAnimalType(){
        return AnimalType.DEER;
    }

}
