package recipes.service;

import recipes.models.Recipe;

public interface RecipesService {
    boolean deleteRecipe(long id);

    Recipe createRecipe(Recipe recipe);

    Recipe getRecipe(long id);
}
