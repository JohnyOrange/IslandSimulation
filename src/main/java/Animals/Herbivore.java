package Animals;

import AnimalFactory.Gender;
import Island.Cell;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Herbivore extends Animal{
    public Herbivore(double weight, int maxCellPopulation, int speed, double maxSaturation, Cell cell, int offspring, Gender gender) {
        super(weight, maxCellPopulation, speed, maxSaturation, cell, offspring, gender);
    }

    @Override
    public void eat() {
        Eatable food = cell.getVegetation();
        consume(food);
    }

    @Override
    Cell findFood() {
        Cell destinationCell = cell;
        Cell[][] islandMap = destinationCell.getIsland().getIslandMap();
        while (destinationCell.getVegetation().getVegetaionLevel() == 0){
            int xCoordinate = cell.getxCoordinate();
            int yCoordinate = cell.getyCoordinate();
            List<Cell> allCellsList = new ArrayList<>();
            for (Cell[] cells : islandMap) {
                allCellsList.addAll(Arrays.asList(cells));
            }
            List<Cell> cellsWithFood;
            cellsWithFood =  allCellsList.stream().filter(cell1 -> cell1.getVegetation().getVegetaionLevel() > 0)
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
        return destinationCell;
    }
}
