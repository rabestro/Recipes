package recipes.service;

import org.springframework.stereotype.Service;
import recipes.models.Recipe;

@Service
public class RecipesServiceImpl implements RecipesService {
    @Override
    public boolean deleteRecipe(long id) {
        return false;
    }

    @Override
    public Recipe createRecipe(Recipe recipe) {
        return null;
    }

    @Override
    public Recipe getRecipe(long id) {
        return null;
    }
}
