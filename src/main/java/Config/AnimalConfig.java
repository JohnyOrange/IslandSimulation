package Config;

import Animals.Animal;

import java.util.ArrayList;
import java.util.List;

public class AnimalConfig {
    private List<AnimalConfigRow> rows = new ArrayList<>();

    public Double getFor(String animal, String parameter) {
        AnimalConfigRow row = rows.stream()
                .filter(animalConfigRow -> animalConfigRow.getAnimalName().equals(animal))
                .findFirst()
                .get();

        return row.getParameters().get(parameter);
    }
}
