package recipes.service;

import org.springframework.stereotype.Service;
import recipes.models.Recipe;
import recipes.repositories.RecipesRepository;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class RecipesServiceImpl implements RecipesService {
    private final RecipesRepository recipesRepository;

    public RecipesServiceImpl(RecipesRepository recipesRepository) {
        this.recipesRepository = recipesRepository;
    }

    @Override
    public void deleteRecipe(Long id) {
        var recipe = recipesRepository.findById(id).orElseThrow(NoSuchElementException::new);
        recipesRepository.delete(recipe);
    }

    @Override
    public Recipe createRecipe(Recipe recipe) {
        return recipesRepository.saveAndFlush(recipe);
    }

    @Override
    public Optional<Recipe> getRecipe(Long id) {
        return recipesRepository.findById(id);
    }
}
