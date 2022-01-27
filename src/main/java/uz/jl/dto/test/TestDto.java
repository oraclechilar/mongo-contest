package uz.jl.dto.test;

import lombok.*;
import uz.jl.dto.GenericDto;
import uz.jl.entity.answer.Answer;

import java.util.List;

/**
 * @author Bakhromjon Wed, 9:38 AM 1/26/2022
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TestDto extends GenericDto {
    private String question;
    private List<Answer> answers;
}
