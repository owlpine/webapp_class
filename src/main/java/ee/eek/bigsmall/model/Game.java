package ee.eek.bigsmall.model;
// "model" package = "entity" package
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("big_small") // somehow table name must be capitalized (for h2)
public class Game {
    //    use snake_case in .sql but camelCase in Java
    @Id
    private Long id;

    private String name;
    private Long answer;
}
