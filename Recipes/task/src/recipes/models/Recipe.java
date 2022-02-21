package recipes.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "RECIPES")
public class Recipe {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotEmpty
    @Size(min = 1)
    @Column(name = "ingredients")
    @ElementCollection
    @CollectionTable(name = "INGREDIENTS", joinColumns = @JoinColumn(name = "id"))
    private List<String> ingredients = new ArrayList<>();

    @NotEmpty
    @Size(min = 1)
    @Column(name = "directions")
    @CollectionTable(name = "DIRECTIONS", joinColumns = @JoinColumn(name = "id"))
    @ElementCollection
    private List<String> directions = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Recipe recipe = (Recipe) o;
        return id != null && Objects.equals(id, recipe.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
