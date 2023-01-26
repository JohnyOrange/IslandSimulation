package Animals.Herbivores;

import AnimalFactory.AnimalType;
import AnimalFactory.Gender;
import Animals.Herbivore;
import Island.Cell;

public class Sheep extends Herbivore {
    public Sheep(double weight, int maxCellPopulation, int speed, double maxSaturation, Cell cell, int offspring, Gender gender) {
        super(weight, maxCellPopulation, speed, maxSaturation, cell, offspring, gender);
    }

    public AnimalType getAnimalType(){
        return AnimalType.SHEEP;
    }

}
