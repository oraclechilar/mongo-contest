package uz.jl.ui;

import org.bson.types.ObjectId;
import uz.jl.criteria.answer.AnswerCriteria;
import uz.jl.dto.answer.AnswerCreateDto;
import uz.jl.dto.answer.AnswerDto;
import uz.jl.dto.answer.AnswerUpdateDto;
import uz.jl.response.Data;
import uz.jl.response.ResponseEntity;
import uz.jl.services.answer.AnswerService;
import uz.jl.utils.Input;

import java.util.List;

/**
 * @author Bakhromjon Wed, 8:23 PM 1/26/2022
 */
public class AnswerUI extends AbstractUI<AnswerService> implements GenericCrudUI{
    public AnswerUI(AnswerService service) {
        super(service);
    }
    @Override
    public void create() {
        String text = Input.getStr("Enter text: ");
        String choice = Input.getStr("Is Correct (true/false)");
        boolean isCorrect = choice.equalsIgnoreCase("true");
        AnswerCreateDto answerCreateDto = new AnswerCreateDto();
        answerCreateDto.setText(text);
        answerCreateDto.setCorrect(isCorrect);
        ResponseEntity<Data<ObjectId>> response = service.create(answerCreateDto);
        showResponse(response);
    }

    @Override
    public void delete() {
        String id = Input.getStr("Enter answer id: ");
        ResponseEntity<Data<Void>> response = service.delete(new ObjectId(id));
        showResponse(response);
    }

    @Override
    public void update() {
        String text = Input.getStr("Enter text: ");
        String choice = Input.getStr("Is Correct (true/false)");
        boolean isCorrect = choice.equalsIgnoreCase("true");
        AnswerUpdateDto answerUpdateDto = new AnswerUpdateDto();
        answerUpdateDto.setText(text);
        answerUpdateDto.setCorrect(isCorrect);
        ResponseEntity<Data<Void>> response = service.update(answerUpdateDto);
        showResponse(response);
    }

    @Override
    public void list() {
        ResponseEntity<Data<List<AnswerDto>>> list = service.list(new AnswerCriteria());
        showResponse(list);
    }

    @Override
    public void get() {
        String id = Input.getStr("Enter answer id: ");
        ResponseEntity<Data<AnswerDto>> response = service.get(new ObjectId(id));
        showResponse(response);
    }
}
