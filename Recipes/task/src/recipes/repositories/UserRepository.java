package recipes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import recipes.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
