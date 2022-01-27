package uz.jl.repository.answer;

import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;
import org.bson.types.ObjectId;
import uz.jl.criteria.answer.AnswerCriteria;
import uz.jl.criteria.test.TestCriteria;
import uz.jl.dao.GenericDao;
import uz.jl.entity.answer.Answer;
import uz.jl.entity.test.Test;
import uz.jl.repository.GenericCrudRepository;
import uz.jl.repository.GenericRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Bakhromjon Wed, 9:34 AM 1/26/2022
 */
public class AnswerRepository extends GenericDao<AnswerCriteria, Answer>
        implements GenericCrudRepository<Answer, ObjectId>,
        GenericRepository<Answer, AnswerCriteria, ObjectId> {

    public AnswerRepository(Class<Answer> clazz) {
        super(clazz);
    }

    @Override
    public ObjectId create(Answer answer) {
        collection.insertOne(answer);
        return answer.getId();
    }

    @Override
    public void delete(ObjectId key) {
        // TODO: 1/26/2022 Javohir aka ko'rib beradilar
    }

    @Override
    public void update(Answer answer) {
        // TODO: 1/26/2022 Javohir aka ko'rib beradilar
    }

    @Override
    public List<Answer> list(AnswerCriteria criteria) {
        List<Answer> answers = new ArrayList<>();
        FindIterable<Answer> list = collection.find(Filters.ne("deleted", true));
        answers.iterator().forEachRemaining(answers::add);
        return answers;
    }

    @Override
    public Optional<Answer> get(ObjectId key) {
        Answer test = collection.find(Filters.eq("_id", key)).first();
        return Optional.of(test);
    }
}
