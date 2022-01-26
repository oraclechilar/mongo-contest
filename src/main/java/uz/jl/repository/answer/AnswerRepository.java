package uz.jl.repository;

import org.bson.types.ObjectId;
import uz.jl.criteria.AnswerCriteria;
import uz.jl.criteria.SubjectCriteria;
import uz.jl.dao.GenericDao;
import uz.jl.entity.answer.Answer;
import uz.jl.entity.subject.Subject;

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
    public ObjectId create(Answer entity) {
        return null;
    }

    @Override
    public void delete(ObjectId key) {

    }

    @Override
    public void update(Answer entity) {

    }

    @Override
    public List<Answer> list(AnswerCriteria criteria) {
        return null;
    }

    @Override
    public Optional<Answer> get(ObjectId key) {
        return Optional.empty();
    }
}
