package uz.jl.services.test;

import org.bson.types.ObjectId;
import uz.jl.criteria.test.TestCriteria;
import uz.jl.dto.test.TestCreateDto;
import uz.jl.dto.test.TestDto;
import uz.jl.dto.test.TestUpdateDto;
import uz.jl.entity.test.Test;
import uz.jl.enums.HttpStatus;
import uz.jl.exception.CustomException;
import uz.jl.mappers.test.TestMapper;
import uz.jl.repository.test.TestRepository;
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
public class TestService extends AbstractService<TestRepository, TestMapper>
        implements GenericCrudService<TestCreateDto, TestUpdateDto, ObjectId>, GenericService<TestDto, TestCriteria, ObjectId> {
    public TestService(TestRepository repository, TestMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public ResponseEntity<Data<ObjectId>> create(TestCreateDto createDto) {
        // TODO: 1/26/2022 validOnCreate
        Test test = mapper.fromCreateDto(createDto);
        ObjectId objectId = repository.create(test);
        return new ResponseEntity<>(new Data<>(objectId));
    }

    @Override
    public ResponseEntity<Data<Void>> delete(ObjectId key) {
        repository.delete(key);
        return new ResponseEntity<>(new Data<>());
    }

    @Override
    public ResponseEntity<Data<Void>> update(TestUpdateDto updateDto) {
        // TODO: 1/26/2022 ValidOnUpdate
        Test test = mapper.fromUpdateDto(updateDto);
        repository.update(test);
        return new ResponseEntity<>(new Data<>());
    }

    @Override
    public ResponseEntity<Data<List<TestDto>>> list(TestCriteria criteria) {
        List<Test> list = repository.list(criteria);
        List<TestDto> testDtos = list.stream().map(mapper::toDto).toList();
        return new ResponseEntity<>(new Data<>(testDtos));
    }

    @Override
    public ResponseEntity<Data<TestDto>> get(ObjectId key) {
        Optional<Test> optional = repository.get(key);
        // TODO: 1/26/2022 Optionalni almashtirish kerak
        Test test = optional.get();
        if (Objects.nonNull(test)) {
            return new ResponseEntity<>(new Data<>(mapper.toDto(test)));
        }
        throw new CustomException("No Found", HttpStatus.HTTP_404);
    }
}
