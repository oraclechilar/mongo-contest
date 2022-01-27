package uz.jl.entity.test;

import lombok.*;
import org.bson.types.ObjectId;
import uz.jl.entity.Auditable;
import uz.jl.entity.answer.Answer;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString(callSuper = true)
@Builder
public class Test extends Auditable {
    private String question;
    private List<Answer> answers;
}
