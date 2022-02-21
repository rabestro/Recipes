package recipes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import recipes.models.Recipe;

@Repository
public interface RecipesRepository extends JpaRepository<Recipe, Long> {
}
