import Config.DemoConfig;
import Engine.Simulation;
import Engine.WorldGenerator;
import Island.Island;
public class Main {
    public static void main(String[] args) {


        Island island = WorldGenerator.generate(DemoConfig.WIDTH, DemoConfig.HEIGHT);
        Simulation.startSimulation(island);
    }
}
