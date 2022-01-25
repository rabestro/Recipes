package recipes.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import recipes.models.Recipe;

@RestController
@RequestMapping("/api/recipe")
public class RecipesController {
    private Recipe recipe;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Recipe create(@RequestBody final Recipe recipe) {
        return this.recipe = recipe;
    }

    @GetMapping
    public Recipe get() {
        return recipe;
    }
}
