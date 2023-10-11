package ee.eek.intro.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class HelloResponse {
    private String fullName;
    private String university;
    private String role;
}
