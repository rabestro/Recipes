package recipes.service;

import recipes.models.Recipe;

import java.util.Optional;

/**
 * This service provides basic recipe operations.
 */
public interface RecipesService {
    void delete(Long id);

    Recipe create(Recipe recipe);

    Optional<Recipe> get(Long id);

    void update(Recipe recipe);
}
