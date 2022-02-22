package recipes.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import recipes.models.Recipe;
import recipes.service.RecipesService;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;
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

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Valid @RequestBody final Recipe recipe, @PathVariable Long id) {
        recipe.setId(id);
        try {
            recipesService.update(recipe);
        } catch (NoSuchElementException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
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

    @GetMapping("search")
    public List<Recipe> search(
            @RequestParam(required = false) @NotBlank String category,
            @RequestParam(required = false) @NotBlank String name
    ) {
        if (category == null ^ name == null) {
            return name == null
                    ? recipesService.findByCategory(category)
                    : recipesService.findByName(name);
        }

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Exactly one search parameter must be specified");
    }
}
