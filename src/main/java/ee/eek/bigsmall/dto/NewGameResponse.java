package ee.eek.bigsmall.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class NewGameResponse {
    private Long gameID;
}
