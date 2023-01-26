package AnimalFactory;

import Animals.Animal;
import Animals.Herbivores.*;
import Animals.Predators.*;
import Island.Cell;
import java.util.Random;

import static Config.GameConfig.ANIMAL_CONFIG;


public class AnimalFactory{
    public static Animal createRandomAnimal(Cell cell){
        Random random = new Random();
        AnimalType[] animalTypes = AnimalType.values();
        AnimalType type = animalTypes[random.nextInt(animalTypes.length)];
        return createAnimalByType(cell, type);
    }
    public static Animal createAnimalByType(Cell cell, AnimalType type){
        Animal animal = null;
        double weight = ANIMAL_CONFIG.getFor(type.toString().toLowerCase(), "weight");
        double maxCellCapacity = ANIMAL_CONFIG.getFor(type.toString().toLowerCase(), "maxCellPopulation");
        double speed = ANIMAL_CONFIG.getFor(type.toString().toLowerCase(), "speed");
        double maxSaturation = ANIMAL_CONFIG.getFor(type.toString().toLowerCase(), "maxSaturation");
        double offspring = ANIMAL_CONFIG.getFor(type.toString().toLowerCase(), "offspring");
        Gender gender = getGender();
        switch (type) {
            case WOLF -> animal = new Wolf(weight, (int) maxCellCapacity, (int) speed, maxSaturation, cell, (int) offspring, gender);
            case SNAKE -> animal = new Snake(weight, (int)maxCellCapacity, (int)speed, maxSaturation, cell, (int) offspring, gender);
            case FOX -> animal = new Fox(weight, (int) maxCellCapacity, (int) speed, maxSaturation, cell, (int) offspring, gender);
            case BEAR -> animal = new Bear(weight, (int) maxCellCapacity, (int) speed, maxSaturation, cell, (int) offspring, gender);
            case EAGLE -> animal = new Eagle(weight, (int) maxCellCapacity, (int) speed, maxSaturation, cell, (int) offspring, gender);
            case HORSE -> animal = new Horse(weight, (int) maxCellCapacity, (int) speed, maxSaturation, cell, (int) offspring, gender);
            case DEER -> animal = new Deer(weight, (int) maxCellCapacity, (int) speed, maxSaturation, cell, (int) offspring, gender);
            case RABBIT -> animal = new Rabbit(weight, (int) maxCellCapacity, (int) speed, maxSaturation, cell, (int) offspring, gender);
            case MOUSE -> animal = new Mouse(weight, (int) maxCellCapacity, (int) speed, maxSaturation, cell, (int) offspring, gender);
            case GOAT -> animal = new Goat(weight, (int) maxCellCapacity, (int) speed, maxSaturation, cell, (int) offspring, gender);
            case SHEEP -> animal = new Sheep(weight, (int) maxCellCapacity, (int) speed, maxSaturation, cell, (int) offspring, gender);
            case BOAR -> animal = new Boar(weight, (int) maxCellCapacity, (int) speed, maxSaturation, cell, (int) offspring, gender);
            case BUFFALO -> animal = new Buffalo(weight, (int) maxCellCapacity, (int) speed, maxSaturation, cell, (int) offspring, gender);
            case DUCK -> animal = new Duck(weight, (int) maxCellCapacity, (int) speed, maxSaturation, cell, (int) offspring, gender);
            case CATERPILLAR -> animal = new Caterpillar(weight, (int) maxCellCapacity, (int) speed, maxSaturation, cell, (int) offspring, gender);
        }
        return animal;
    }

    private static Gender getGender() {
        Random random = new Random();
        if (random.nextBoolean()){
            return Gender.FEMALE;
        } else {
            return Gender.MALE;
        }
    }
}
