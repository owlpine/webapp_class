package ee.eek.bigsmall.dto;

import lombok.Data;

@Data
public class NewGameRequest {
    private String name;
    private Long answer;
}
