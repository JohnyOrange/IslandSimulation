package Animals;

import AnimalFactory.AnimalFactory;
import AnimalFactory.AnimalType;
import AnimalFactory.Gender;
import Island.Cell;
import Island.Plants;

import java.util.List;
import java.util.Random;

public abstract class Animal implements Eatable{
    double weight;
    final int maxCellPopulation;
    int speed;
    double maxSaturation;

    double saturation;
    boolean isDead = false;
    Cell cell;
    int offspring;
    Gender gender;
    int daysBeforeDecay = 3;


    public Animal(double weight, int maxCellPopulation, int speed, double maxSaturation, Cell cell, int offspring, Gender gender){
        this.weight = weight;
        this.maxCellPopulation = maxCellPopulation;
        this.speed = speed;
        this.maxSaturation = maxSaturation;
        this.cell = cell;
        this.offspring = offspring;
        this.gender = gender;
    }

    public void live(){
        if (!isDead){
            move();
            eat();
            reproduce();
            finishDay();
        } else if (daysBeforeDecay > 0){
            daysBeforeDecay--;
        } else {
            weight = 0.0;
        }

    }


    void move(){
        Cell destinationCell = findFood();
        Cell currentCell = cell;

        if (cell == destinationCell){
            return;
        }
        if (speed == 0){
            return;
        }
        int remainMoves = speed;
        cell.getAnimalList().remove(this);
        while (cell != destinationCell && remainMoves > 0){

            if (cell.getxCoordinate() == destinationCell.getxCoordinate()){
                moveYAxis(destinationCell);
            } else if (cell.getyCoordinate() == destinationCell.getyCoordinate()) {
                moveXAxis(destinationCell);
            } else {
                moveXAxis(destinationCell);
                moveYAxis(destinationCell);
            }
            remainMoves--;
        }
        cell.getAnimalList().add(this);
        //System.out.println(this.getAnimalType().getPicture() + " moves " + " from " + currentCell + " to " + cell );
    }
    void eat(){

    }
    void reproduce(){
        if (gender == Gender.FEMALE){
            //System.out.print(this.getAnimalType().getPicture() + " try to reproduce: ");
            List<Animal> population = cell.getAnimalList().stream()
                    .filter(animal -> animal.getAnimalType() == this.getAnimalType())
                    .toList();
            Animal partner = population.stream()
                    .filter(animal -> animal.getAnimalType() == this.getAnimalType())
                    .filter(animal -> animal.getGender() != this.gender)
                    .findFirst()
                    .orElse(null);
            if (partner != null && population.size() < maxCellPopulation){
                Random random = new Random();
                for (int i = 0; i < random.nextInt(offspring); i++) {
                    cell.getAnimalList().add(AnimalFactory.createAnimalByType(cell, getAnimalType()));
                }
                //System.out.println("succesfull");
            }
        }
    }
    private void finishDay() {
        saturation = saturation - maxSaturation * 0.3;
        if (saturation <= 0.0){
            saturation = 0;
            die();
            //System.out.println(this.getAnimalType().getPicture() + "died because of hunger");
        }
    }
    void die(){
        isDead = true;
    }
    Cell findFood() {
        return null;
    }
    private void moveYAxis(Cell destinationCell){
        if (cell.getyCoordinate() > destinationCell.getyCoordinate()){
            cell = cell.getIsland().getIslandMap()[cell.getxCoordinate()][cell.getyCoordinate() - 1];
        } else {
            cell = cell.getIsland().getIslandMap()[cell.getxCoordinate()][cell.getyCoordinate() + 1];
        }
    }
    private void moveXAxis(Cell destinationCell){
        if (cell.getxCoordinate() > destinationCell.getxCoordinate()){
            cell = cell.getIsland().getIslandMap()[cell.getxCoordinate() - 1][cell.getyCoordinate()];
        } else {
            cell = cell.getIsland().getIslandMap()[cell.getxCoordinate() + 1][cell.getyCoordinate()];
        }
    }
    void consume(Eatable food){
        double readyToConsume = maxSaturation - saturation;
        double availableSatuation = food.satiate();
        if (food instanceof Animal){
            Animal animal = (Animal) food;
            animal.die();
            if (animal.satiate() > 0){
                if (readyToConsume >= availableSatuation){
                    saturation = saturation + availableSatuation;
                    animal.setWeight(0.0);
                } else {
                    saturation = saturation + readyToConsume;
                    animal.setWeight(availableSatuation - readyToConsume);
                }
            }
        }
        if (food instanceof Plants){
            Plants plants = (Plants) food;
            if (plants.satiate() > 0){
                if (readyToConsume >= availableSatuation){
                    saturation = saturation + availableSatuation;
                    plants.setVegetaionLevel(0.0);
                } else {
                    saturation = saturation + readyToConsume;
                    plants.setVegetaionLevel(availableSatuation - readyToConsume);
                }
            }
        }
    }
    @Override
    public double satiate() {
        return weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getMaxCellPopulation() {
        return maxCellPopulation;
    }
    public boolean isDead() {
        return isDead;
    }
    public AnimalType getAnimalType(){
        return null;
    }
    public Gender getGender() {
        return gender;
    }
    public void setSaturation(double saturation) {
        this.saturation = saturation;
    }

    public double getMaxSaturation() {
        return maxSaturation;
    }
}
