package trainual.userservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@NoArgsConstructor
public class ReviewRequestDto {

    @NotNull
    private String description;
}
