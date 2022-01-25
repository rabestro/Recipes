package recipes.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Recipe {
    private String name;
    private String description;
    private List<String> ingredients;
    private List<String> directions;
}
