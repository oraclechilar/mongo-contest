package uz.jl.dto.answer;

import lombok.*;
import uz.jl.dto.GenericDto;

/**
 * @author Bakhromjon Wed, 9:36 AM 1/26/2022
 */
@Setter
@Getter
@Builder
public class AnswerDto extends GenericDto {
    private String text;
    private boolean isCorrect;
    private boolean selected;

}
