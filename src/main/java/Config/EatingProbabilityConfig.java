package Config;


import Animals.Animal;

import java.util.ArrayList;
import java.util.List;

public class EatingProbabilityConfig {
    private List<EatingConfigRow> rows = new ArrayList<>();

    public Double getFor(String predator, String food) {
        EatingConfigRow row = rows.stream()
            .filter(eatingConfigRow -> eatingConfigRow.getAnimalName().equals(predator))
            .findFirst()
            .get();

        return row.getProbabilities().get(food) / 100.0;
    }
}
