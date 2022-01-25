package recipes.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import recipes.models.Key;
import recipes.models.Recipe;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/recipe")
public class RecipesController {
    private final Map<Long, Recipe> repository = new HashMap<>();
    private long id = 0;

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.OK)
    public Key create(@RequestBody final Recipe recipe) {
        repository.put(++id, recipe);
        return new Key(id);
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
}
