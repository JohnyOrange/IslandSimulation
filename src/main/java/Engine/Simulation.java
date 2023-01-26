package Engine;

import Animals.Animal;
import Island.Island;
import Island.Cell;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private static int dayCounter = 0;

    public static void startSimulation(Island island){
        while (dayCounter < 20){
            InfoOutput.printInfo(island);
            Cell[][] islandMap = island.getIslandMap();
            List<Animal> animalList = new ArrayList<>();
            for (int i = 0; i < islandMap.length; i++) {
                for (int j = 0; j < islandMap[i].length; j++) {
                    Cell cell = islandMap[i][j];
                    cell.getVegetation().grow();
                    animalList.addAll(cell.getAnimalList());
                }
            }
            for (Animal animal : animalList) {
                animal.live();
            }
            dayCounter++;
        }
    }
    public static int getDayCounter() {
        return dayCounter;
    }
}
