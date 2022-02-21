package recipes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import recipes.models.Recipe;

public interface RecipesRepository extends JpaRepository<Recipe, Long> {
}
