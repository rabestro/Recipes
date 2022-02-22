package recipes.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import recipes.models.Recipe;
import recipes.service.RecipesService;

import javax.validation.Valid;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/recipe")
public class RecipesController {
    private final RecipesService recipesService;

    public RecipesController(RecipesService recipesService) {
        this.recipesService = recipesService;
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Long> create(@Valid @RequestBody final Recipe recipe) {
        recipesService.create(recipe);
        return Map.of("id", recipesService.create(recipe).getId());
    }

    @GetMapping("{id}")
    public Recipe get(@PathVariable Long id) {
        return recipesService.get(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        try {
            recipesService.delete(id);
        } catch (NoSuchElementException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
