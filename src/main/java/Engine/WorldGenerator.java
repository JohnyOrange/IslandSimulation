package Engine;

import AnimalFactory.AnimalFactory;
import Animals.Animal;
import Island.Plants;
import Island.Island;
import Island.Cell;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static Config.GameConfig.ANIMAL_CONFIG;

public class WorldGenerator {
    public static Island generate(int width, int height){
        
        Island island = new Island(height, width);

        Cell[][] islandMap = island.getIslandMap();

        double maxPlantsCapacity = ANIMAL_CONFIG.getFor("plants", "maxCellPopulation");
        double plantsGrowSpeed = ANIMAL_CONFIG.getFor("plants", "offspring");
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Cell cell = islandMap[i][j];
                List<Animal> animalList = generateAnimals(cell);
                cell.setAnimalList(animalList);
                cell.setVegetation(new Plants(maxPlantsCapacity, plantsGrowSpeed, generateVegetationLevel(maxPlantsCapacity)));
                animalList.forEach(animal -> animal.setSaturation(animal.getMaxSaturation() * 0.5));
            }
        }
        return island;
    }

    private static List<Animal> generateAnimals(Cell cell) {
        Random random = new Random();
        List<Animal> animalList = new ArrayList<>();
        for (int i = 0; i < random.nextInt(30); i++) {
            animalList.add(AnimalFactory.createRandomAnimal(cell));

        }
        return animalList;
    }

    private static double generateVegetationLevel(double maxPlantsCapacity){
        Random random = new Random();
        return random.nextDouble(maxPlantsCapacity);
    }
}
