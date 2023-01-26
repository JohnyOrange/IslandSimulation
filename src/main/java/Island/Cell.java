package Island;

import Animals.Animal;

import java.util.List;

public class Cell {
    private final int xCoordinate;
    private final int yCoordinate;
    private final Island island;
    private List<Animal> animalList;
    private Plants vegetation;

    public Cell(int xCoordinate, int yCoordinate, Island island) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.island = island;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public List<Animal> getAnimalList() {
        return animalList;
    }

    public void setAnimalList(List<Animal> animalList) {
        this.animalList = animalList;
    }

    public Plants getVegetation() {
        return vegetation;
    }

    public void setVegetation(Plants vegetation) {
        this.vegetation = vegetation;
    }

    public Island getIsland() {
        return island;
    }
}
