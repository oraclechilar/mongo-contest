package uz.jl.entity.quiz;

import lombok.*;
import org.bson.types.ObjectId;
import uz.jl.entity.Auditable;
import uz.jl.entity.test.Test;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
public class Quiz extends Auditable {
    private List<Test> tests;
    private Date deadline;
    private boolean is_completed;
    private int mark;

    public Quiz(ObjectId id, Date createdAt, Date updatedAt, boolean deleted, List<Test> tests, Date deadline, boolean is_completed, int mark) {
        super(id, createdAt, updatedAt, deleted);
        this.tests = tests;
        this.deadline = deadline;
        this.is_completed = is_completed;
        this.mark = mark;
    }
}
