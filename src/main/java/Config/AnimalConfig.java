package Config;

import java.util.ArrayList;
import java.util.List;

public class AnimalConfig {
    private List<AnimalConfigRow> rows = new ArrayList<>();

    public List<AnimalConfigRow> getRows() {
        return rows;
    }

    public void setRows(List<AnimalConfigRow> rows) {
        this.rows = rows;
    }

    public Double getFor(String animal, String parameter) {
        AnimalConfigRow row = rows.stream()
                .filter(animalConfigRow -> animalConfigRow.getAnimalName().equals(animal))
                .findFirst()
                .get();

        return row.getParameters().get(parameter);
    }
}
