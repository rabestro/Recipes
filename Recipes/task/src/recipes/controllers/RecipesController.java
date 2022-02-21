package recipes.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import recipes.models.Recipe;
import recipes.service.RecipesService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/recipe")
public class RecipesController {
    private final RecipesService recipesService;

    private final Map<Long, Recipe> repository = new HashMap<>();
    private long id = 0;

    public RecipesController(RecipesService recipesService) {
        this.recipesService = recipesService;
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Long> create(@RequestBody final Recipe recipe) {
        repository.put(++id, recipe);
        return Map.of("id", id);
    }

    @GetMapping
    @RequestMapping("{id}")
    public Recipe get(@PathVariable Long id) {
        var recipe = repository.get(id);
        if (recipe == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
        }
        return recipe;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable long id) {
        if (!recipesService.deleteRecipe(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
