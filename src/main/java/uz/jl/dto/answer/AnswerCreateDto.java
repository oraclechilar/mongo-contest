package uz.jl.dto.answer;

import lombok.*;
import uz.jl.dto.GenericBaseDto;

/**
 * @author Bakhromjon Wed, 9:36 AM 1/26/2022
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnswerCreateDto implements GenericBaseDto {
    private String text;
    private boolean isCorrect;
}
