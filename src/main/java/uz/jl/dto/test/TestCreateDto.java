package uz.jl.dto.test;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.jl.dto.GenericBaseDto;
import uz.jl.entity.answer.Answer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bakhromjon Wed, 9:39 AM 1/26/2022
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TestCreateDto implements GenericBaseDto {
    private String question;
    private List<Answer> answers = new ArrayList<>();
}
