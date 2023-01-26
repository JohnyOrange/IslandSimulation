package Config;

import com.fasterxml.jackson.databind.json.JsonMapper;

import java.io.File;
import java.net.URL;
import java.nio.file.Paths;

public class GameConfig {
    public  static final String EATING_PROBABILITIES_CONFIG_FILE_PATH = "/eatingProbabilities.json";
    public static final EatingProbabilityConfig EATING_PROBABILITY_CONFIG = initEatingProbablitiesConfig();

    public static final String ANIMAL_CONFIG_FILE_PATH = "/animalConfig.json";
    public static final AnimalConfig ANIMAL_CONFIG = initAnimalConfig();

    private static AnimalConfig initAnimalConfig() {
        try {
            URL resource = GameConfig.class.getResource(ANIMAL_CONFIG_FILE_PATH);
            File file = Paths.get(resource.toURI()).toFile();
            JsonMapper jsonMapper = new JsonMapper();
            return jsonMapper.readValue(file, AnimalConfig.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    private static EatingProbabilityConfig initEatingProbablitiesConfig() {
        try {
            URL resource = GameConfig.class.getResource(EATING_PROBABILITIES_CONFIG_FILE_PATH);
            File file = Paths.get(resource.toURI()).toFile();
            JsonMapper jsonMapper = new JsonMapper();
            return jsonMapper.readValue(file, EatingProbabilityConfig.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}