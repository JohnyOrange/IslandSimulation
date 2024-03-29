package Engine;

import AnimalFactory.AnimalFactory;
import Animals.Eatable;
import Island.Plants;
import Island.Island;
import Island.Cell;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static Config.GameConfig.ANIMAL_CONFIG;
import static Config.GameConfig.ISLAND_CONFIG;

public class WorldGenerator {

    public static Island generate(){

        int height = ISLAND_CONFIG.getIslandHeight();
        int width = ISLAND_CONFIG.getIslandWidth();
        
        Island island = new Island(height, width);

        Cell[][] islandMap = island.getIslandMap();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Cell cell = islandMap[i][j];
                List<Eatable> eatables = new ArrayList<>();
                eatables.addAll(generatePlants(cell));
                eatables.addAll(generateAnimals(cell));
                cell.setEatableList(eatables);
            }
        }
        return island;
    }

    private static List<Eatable> generateAnimals(Cell cell) {
        Random random = new Random();
        List<Eatable> animalList = new ArrayList<>();
        int bound = ISLAND_CONFIG.getStartupAnimalGenerationOnCell();
        for (int i = 0; i < random.nextInt(bound); i++) {
            animalList.add(AnimalFactory.createRandomAnimal(cell));
        }
        return animalList;
    }

    private static List<Eatable> generatePlants(Cell cell){
        Random random = new Random();
        List<Eatable> plantsList = new ArrayList<>();
        double maxCellPopulation = ANIMAL_CONFIG.getFor("plants", "maxCellPopulation"); //move to IslandConfig ??/?
        double growSpeed = ANIMAL_CONFIG.getFor("plants", "offspring");
        double weight = ANIMAL_CONFIG.getFor("plants", "weight");
        for (int i = 0; i < random.nextDouble(maxCellPopulation); i++) {
            plantsList.add(new Plants(maxCellPopulation, growSpeed, weight, cell));
        }
        return plantsList;
    }
}
