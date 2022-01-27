package uz.jl.mappers.answer;

import uz.jl.dto.answer.AnswerCreateDto;
import uz.jl.dto.answer.AnswerDto;
import uz.jl.dto.answer.AnswerUpdateDto;
import uz.jl.entity.answer.Answer;
import uz.jl.mappers.GenericMapper;

/**
 * @author Bakhromjon Wed, 4:00 PM 1/26/2022
 */
public class AnswerMapper implements GenericMapper<Answer, AnswerDto, AnswerCreateDto, AnswerUpdateDto> {
    @Override
    public Answer fromDto(AnswerDto dto) {
        return Answer.builder()
                .text(dto.getText())
                .isCorrect(dto.isCorrect()).build();
    }

    @Override
    public Answer fromCreateDto(AnswerCreateDto dto) {
        return Answer.builder()
                .text(dto.getText())
                .isCorrect(dto.isCorrect()).build();
    }

    @Override
    public Answer fromUpdateDto(AnswerUpdateDto dto) {
        return Answer.builder()
                .text(dto.getText())
                .isCorrect(dto.isCorrect())
                .selected(dto.isSelected())
                .build();
    }

    @Override
    public AnswerDto toDto(Answer entity) {
        return AnswerDto.builder().
                text(entity.getText())
                .isCorrect(entity.isCorrect()).build();
    }
}
