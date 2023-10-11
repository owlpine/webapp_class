package ee.eek.intro.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
@Data
public class HelloRequest {
    private String firstName;
    private String lastName;
}
