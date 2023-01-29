package Island;

import Animals.Animal;
import Animals.Eatable;

import java.util.List;

public class Cell {
    private final int xCoordinate;
    private final int yCoordinate;
    private final Island island;
    private List<Eatable> eatableList;

    public Cell(int xCoordinate, int yCoordinate, Island island) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.island = island;
    }
    public synchronized List<Eatable> getEatableList() {
        return eatableList;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setEatableList(List<Eatable> eatableList) {
        this.eatableList = eatableList;
    }
    public Island getIsland() {
        return island;
    }
}
