package uz.jl.ui;

import org.bson.types.ObjectId;
import uz.jl.criteria.test.TestCriteria;
import uz.jl.dto.answer.AnswerCreateDto;
import uz.jl.dto.test.TestCreateDto;
import uz.jl.dto.test.TestDto;
import uz.jl.dto.test.TestUpdateDto;
import uz.jl.entity.answer.Answer;
import uz.jl.mappers.answer.AnswerMapper;
import uz.jl.repository.answer.AnswerRepository;
import uz.jl.response.Data;
import uz.jl.response.ResponseEntity;
import uz.jl.services.answer.AnswerService;
import uz.jl.services.test.TestService;
import uz.jl.utils.Input;

import java.util.List;

/**
 * @author Bakhromjon Wed, 8:17 PM 1/26/2022
 */
public class TestUI extends AbstractUI<TestService> implements GenericCrudUI {
    public TestUI(TestService service) {
        super(service);
    }

    @Override
    public void create() {
        String question = Input.getStr("Enter question: ");
        TestCreateDto testCreateDto = new TestCreateDto();
        testCreateDto.setQuestion(question);
        // TODO: 1/26/2022 add answers
        ResponseEntity<Data<ObjectId>> response = service.create(testCreateDto);
        showResponse(response);
    }

    @Override
    public void delete() {
        String id = Input.getStr("Enter test id: ");
        ResponseEntity<Data<Void>> response = service.delete(new ObjectId(id));
        showResponse(response);
    }

    @Override
    public void update() {
        String question = Input.getStr("Enter question: ");
        TestUpdateDto testUpdateDto = new TestUpdateDto();
        testUpdateDto.setQuestion(question);
        ResponseEntity<Data<Void>> response = service.update(testUpdateDto);
        showResponse(response);
    }

    @Override
    public void list() {
        ResponseEntity<Data<List<TestDto>>> list = service.list(new TestCriteria());
        showResponse(list);
    }

    @Override
    public void get() {
        String id = Input.getStr("Enter test id: ");
        ResponseEntity<Data<TestDto>> response = service.get(new ObjectId(id));
        showResponse(response);
    }
}
