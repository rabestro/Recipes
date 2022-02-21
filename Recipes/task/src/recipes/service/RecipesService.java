package recipes.service;

import recipes.models.Recipe;

import java.util.Optional;

public interface RecipesService {
    void deleteRecipe(Long id);

    Recipe createRecipe(Recipe recipe);

    Optional<Recipe> getRecipe(Long id);
}
