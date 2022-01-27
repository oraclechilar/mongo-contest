package uz.jl.services.answer;

import org.bson.types.ObjectId;
import uz.jl.criteria.answer.AnswerCriteria;
import uz.jl.dto.answer.AnswerCreateDto;
import uz.jl.dto.answer.AnswerDto;
import uz.jl.dto.answer.AnswerUpdateDto;
import uz.jl.entity.answer.Answer;
import uz.jl.enums.HttpStatus;
import uz.jl.exception.CustomException;
import uz.jl.mappers.answer.AnswerMapper;
import uz.jl.repository.answer.AnswerRepository;
import uz.jl.response.Data;
import uz.jl.response.ResponseEntity;
import uz.jl.services.AbstractService;
import uz.jl.services.GenericCrudService;
import uz.jl.services.GenericService;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author Bakhromjon Wed, 10:04 AM 1/26/2022
 */
public class AnswerService extends AbstractService<AnswerRepository, AnswerMapper>
implements GenericCrudService<AnswerCreateDto, AnswerUpdateDto, ObjectId>, GenericService<AnswerDto, AnswerCriteria, ObjectId> {
    public AnswerService(AnswerRepository repository, AnswerMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public ResponseEntity<Data<ObjectId>> create(AnswerCreateDto createDto) {
        // TODO: 1/26/2022 validOnCreate
        Answer answer = mapper.fromCreateDto(createDto);
        ObjectId objectId = repository.create(answer);
        return new ResponseEntity<>(new Data<>(objectId));
    }

    @Override
    public ResponseEntity<Data<Void>> delete(ObjectId key) {
        repository.delete(key);
        return new ResponseEntity<>(new Data<>());
    }

    @Override
    public ResponseEntity<Data<Void>> update(AnswerUpdateDto updateDto) {
        // TODO: 1/26/2022 ValidOnUpdate
        Answer answer = mapper.fromUpdateDto(updateDto);
        repository.update(answer);
        return new ResponseEntity<>(new Data<>());
    }

    @Override
    public ResponseEntity<Data<List<AnswerDto>>> list(AnswerCriteria criteria) {
        List<Answer> list = repository.list(criteria);
        List<AnswerDto> answerDtos = list.stream().map(mapper::toDto).toList();
        return new ResponseEntity<>(new Data<>(answerDtos));
    }

    @Override
    public ResponseEntity<Data<AnswerDto>> get(ObjectId key) {
        Optional<Answer> optional = repository.get(key);
        // TODO: 1/26/2022 Optionalni almashtirish kerak
        Answer answer = optional.get();
        if (Objects.nonNull(answer)) {
            return new ResponseEntity<>(new Data<>(mapper.toDto(answer)));
        }
        throw new CustomException("No Found", HttpStatus.HTTP_404);
    }
}
