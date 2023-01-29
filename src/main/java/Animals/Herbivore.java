package Animals;

import AnimalFactory.Gender;
import Island.Cell;

public abstract class Herbivore extends Animal{
    public Herbivore(double weight, int maxCellPopulation, int speed, double maxSaturation, Cell cell,
                     int offspring, Gender gender, double saturation, int daysBeforeDecay) {
        super(weight, maxCellPopulation, speed, maxSaturation, cell, offspring, gender, saturation, daysBeforeDecay);
    }


}
