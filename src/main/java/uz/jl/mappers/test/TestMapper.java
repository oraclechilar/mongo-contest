package uz.jl.mappers.test;


import uz.jl.dto.test.TestCreateDto;
import uz.jl.dto.test.TestDto;
import uz.jl.dto.test.TestUpdateDto;
import uz.jl.entity.test.Test;
import uz.jl.mappers.GenericMapper;

/**
 * @author Bakhromjon Wed, 4:00 PM 1/26/2022
 */
public class TestMapper implements GenericMapper<Test, TestDto, TestCreateDto, TestUpdateDto> {
    @Override
    public Test fromDto(TestDto dto) {
        return Test.builder()
                .question(dto.getQuestion())
                .answers(dto.getAnswers()).build();
    }

    @Override
    public Test fromCreateDto(TestCreateDto dto) {
        return Test.builder()
                .question(dto.getQuestion())
                .answers(dto.getAnswers()).build();
    }

    @Override
    public Test fromUpdateDto(TestUpdateDto dto) {
        return Test.builder()
                .question(dto.getQuestion())
                .build();
    }

    @Override
    public TestDto toDto(Test entity) {
        return TestDto.builder().
                question(entity.getQuestion())
                .answers(entity.getAnswers()).build();
    }
}
