package Animals.Predators;

import AnimalFactory.AnimalType;
import AnimalFactory.Gender;
import Animals.Predator;
import Island.Cell;

public class Snake extends Predator {
    public Snake(double weight, int maxCellPopulation, int speed, double maxSaturation, Cell cell, int offspring, Gender gender) {
        super(weight, maxCellPopulation, speed, maxSaturation, cell, offspring, gender);
    }

    public AnimalType getAnimalType(){
        return AnimalType.SNAKE;
    }

}
