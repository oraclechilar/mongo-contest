package uz.jl.entity.quiz;

import lombok.*;
import org.bson.types.ObjectId;
import uz.jl.entity.GenericCollection;
import uz.jl.entity.test.Test;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Quiz extends GenericCollection {
    private List<Test> tests;
    private Date deadline;
    private boolean is_completed;

    @Builder(builderMethodName = "childBuilder")
    public Quiz(ObjectId id, List<Test> tests, Date deadline, boolean is_completed) {
        super(id);
        this.tests = tests;
        this.deadline = deadline;
        this.is_completed = is_completed;
    }
}
