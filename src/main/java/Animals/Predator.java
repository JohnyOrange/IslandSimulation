package Animals;

import AnimalFactory.Gender;
import Island.Cell;

import java.util.*;
import java.util.stream.Collectors;

import static Config.GameConfig.EATING_PROBABILITY_CONFIG;

public class Predator extends Animal{
    public Predator(double weight, int maxCellPopulation, int speed, double maxSaturation, Cell cell, int offspring, Gender gender) {
        super(weight, maxCellPopulation, speed, maxSaturation, cell, offspring, gender);
    }

    @Override
    void eat() {
        List<Animal> animalList = cell.getAnimalList();
        if (animalList.stream().toList().size() > 0){
            Random random = new Random();
            List<Animal> foodList = animalList.stream()
                    .filter(animal -> animal.getAnimalType() != this.getAnimalType())
                    .filter(Animal::isDead)
                    .filter(animal -> animal.satiate() > 0)
                    .collect(Collectors.toList());
            if (foodList.size() > 0){
                if (foodList.size() == 1){
                    Animal food = foodList.get(0);
                    consume(food);
                } else {
                    Animal food = foodList.get(random.nextInt(foodList.size() - 1));
                    //System.out.println(String.format("%s eat dead %s", this.getAnimalType().getPicture(), food.getAnimalType().getPicture()));
                    consume(food);
                }
            }else {
                foodList = animalList.stream()
                        .filter(animal -> !animal.isDead())
                        .filter(animal -> animal.getAnimalType() != this.getAnimalType())
                        .collect(Collectors.toList());
                if (foodList.size() > 0){
                    if (foodList.size() == 1){
                        Animal food = foodList.get(0);
                        Double probability = EATING_PROBABILITY_CONFIG.getFor(this.getAnimalType().toString().toLowerCase(), food.getAnimalType().toString().toLowerCase());
                        //System.out.print(String.format("%s tries to eat %s", this.getAnimalType().getPicture(), food.getAnimalType().getPicture()));
                        if (random.nextDouble(1.0) < probability) {
                            //System.out.println(" successfully");
                            consume(food);
                        } else {
                            //System.out.println(" and failed");
                        }
                    } else {
                        Animal food = foodList.get(random.nextInt(foodList.size() - 1));
                        Double probability = EATING_PROBABILITY_CONFIG.getFor(this.getAnimalType().toString().toLowerCase(), food.getAnimalType().toString().toLowerCase());
                        //System.out.print(String.format("%s tries to eat %s", this.getAnimalType().getPicture(), food.getAnimalType().getPicture()));
                        if (random.nextDouble(1.0) < probability) {
                            //System.out.println(" successfully");
                            consume(food);
                        } else {
                            //System.out.println(" and failed");
                        }
                    }
                }
            }
        }
    }

    @Override
    Cell findFood() {
        Cell destinationCell = cell;
        Cell[][] islandMap = destinationCell.getIsland().getIslandMap();
        while (destinationCell.getAnimalList()
                .stream()
                .filter(animal -> animal.getAnimalType() != this.getAnimalType())
                .filter(animal -> animal.satiate() > 0)
                .toList().size() == 0){
            int xCoordinate = cell.getxCoordinate();
            int yCoordinate = cell.getyCoordinate();
            List<Cell> allCellsList = new ArrayList<>();
            for (Cell[] cells : islandMap) {
                allCellsList.addAll(Arrays.asList(cells));
            }
            List<Cell> cellsWithFood;
            cellsWithFood =  allCellsList.stream()
                    .filter(cell1 -> cell1.getAnimalList().stream()
                            .filter(animal -> animal.getAnimalType() != this.getAnimalType())
                            .filter(animal -> animal.satiate() > 0)
                            .toList().size() > 0)
                    .collect(Collectors.toList());
            if (cellsWithFood.size() == 0){
                break;
            }
            int distance = Integer.MAX_VALUE;
            for (Cell currentCell : cellsWithFood) {
                int distToCurrentCell = Math.abs(currentCell.getxCoordinate() - xCoordinate) + Math.abs(currentCell.getyCoordinate() - yCoordinate);
                if (distToCurrentCell < distance){
                    distance = distToCurrentCell;
                    destinationCell = currentCell;
                }
            }
        }
        return destinationCell;    }
}
