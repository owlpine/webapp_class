package ee.eek.bigsmall.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class GameResponse {
    private String response;
}