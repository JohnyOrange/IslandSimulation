package Engine;

import AnimalFactory.AnimalType;
import Animals.Animal;
import Island.Cell;
import Island.Island;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class InfoOutput {
    public static void printInfo(Island island){
        Cell[][] islandMap = island.getIslandMap();
        List<Animal> animalList = new ArrayList<>();
        double vegetationLevel = 0.0;

        for (int i = 0; i < islandMap.length; i++) {
            for (int j = 0; j < islandMap[i].length; j++) {
                Cell cell = islandMap[i][j];
                animalList.addAll(cell.getAnimalList());
                vegetationLevel = vegetationLevel + cell.getVegetation().getVegetaionLevel();
            }
        }
        System.out.println("\uD83D\uDCC5: " + Simulation.getDayCounter() +
                ", \uD83C\uDF3F: " + new DecimalFormat("#0.00").format(vegetationLevel) + "\t" +
                AnimalType.WOLF.getPicture() + animalList.stream()
                        .filter(animal -> !animal.isDead())
                        .filter(animal -> animal.getAnimalType() == AnimalType.WOLF)
                        .toList().size() + "\t" +
                AnimalType.SNAKE.getPicture() + animalList.stream()
                        .filter(animal -> !animal.isDead())
                        .filter(animal -> animal.getAnimalType() == AnimalType.SNAKE)
                        .toList().size() + "\t" +
                AnimalType.FOX.getPicture() + animalList.stream()
                        .filter(animal -> !animal.isDead())
                        .filter(animal -> animal.getAnimalType() == AnimalType.FOX)
                        .toList().size() + "\t" +
                AnimalType.BEAR.getPicture() + animalList.stream()
                        .filter(animal -> !animal.isDead())
                        .filter(animal -> animal.getAnimalType() == AnimalType.BEAR)
                        .toList().size() + "\t" +
                AnimalType.EAGLE.getPicture() + animalList.stream()
                        .filter(animal -> !animal.isDead())
                        .filter(animal -> animal.getAnimalType() == AnimalType.EAGLE)
                        .toList().size() + "\t" +
                AnimalType.HORSE.getPicture() + animalList.stream()
                        .filter(animal -> !animal.isDead())
                        .filter(animal -> animal.getAnimalType() == AnimalType.HORSE)
                        .toList().size() + "\t" +
                AnimalType.DEER.getPicture() + animalList.stream()
                        .filter(animal -> !animal.isDead())
                        .filter(animal -> animal.getAnimalType() == AnimalType.DEER)
                        .toList().size() + "\t" +
                AnimalType.RABBIT.getPicture() + animalList.stream()
                        .filter(animal -> !animal.isDead())
                        .filter(animal -> animal.getAnimalType() == AnimalType.RABBIT)
                        .toList().size() + "\t" +
                AnimalType.MOUSE.getPicture() + animalList.stream()
                        .filter(animal -> !animal.isDead())
                        .filter(animal -> animal.getAnimalType() == AnimalType.MOUSE)
                        .toList().size() + "\t" +
                AnimalType.GOAT.getPicture() + animalList.stream()
                        .filter(animal -> !animal.isDead())
                        .filter(animal -> animal.getAnimalType() == AnimalType.GOAT)
                        .toList().size() + "\t" +
                AnimalType.SHEEP.getPicture() + animalList.stream()
                        .filter(animal -> !animal.isDead())
                        .filter(animal -> animal.getAnimalType() == AnimalType.SHEEP)
                        .toList().size() + "\t" +
                AnimalType.BOAR.getPicture() + animalList.stream()
                        .filter(animal -> !animal.isDead())
                        .filter(animal -> animal.getAnimalType() == AnimalType.BOAR)
                        .toList().size() + "\t" +
                AnimalType.BUFFALO.getPicture() + animalList.stream()
                        .filter(animal -> !animal.isDead())
                        .filter(animal -> animal.getAnimalType() == AnimalType.BUFFALO)
                        .toList().size() + "\t" +
                AnimalType.DUCK.getPicture() + animalList.stream()
                        .filter(animal -> !animal.isDead())
                        .filter(animal -> animal.getAnimalType() == AnimalType.DUCK)
                        .toList().size() + "\t" +
                AnimalType.CATERPILLAR.getPicture() + animalList.stream()
                        .filter(animal -> !animal.isDead())
                        .filter(animal -> animal.getAnimalType() == AnimalType.CATERPILLAR)
                        .toList().size() + "\t" +
                ", \uD83D\uDC80" + animalList.stream()
                        .filter(Animal::isDead)
                        .toList().size()
                );

    }
}
