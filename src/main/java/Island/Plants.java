package Island;

import Animals.Eatable;

public class Plants implements Eatable {

    private final double maxCellCapacity;
    private final double growSpeed;
    private double vegetaionLevel;
    public Plants(double maxCellCapacity, double growSpeed, double vegetaionLevel) {
        this.maxCellCapacity = maxCellCapacity;
        this.growSpeed = growSpeed;
        this.vegetaionLevel = vegetaionLevel;
    }

    @Override
    public double satiate() {

        return vegetaionLevel;
    }

    public void grow(){
        vegetaionLevel = vegetaionLevel * growSpeed;
        if (vegetaionLevel > maxCellCapacity){
            vegetaionLevel = maxCellCapacity;
        }
    }
    public double getVegetaionLevel() {
        return vegetaionLevel;
    }

    public void setVegetaionLevel(double vegetaionLevel) {
        this.vegetaionLevel = vegetaionLevel;
    }


}
