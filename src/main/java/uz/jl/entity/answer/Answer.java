package uz.jl.entity.answer;

import lombok.*;
import org.bson.types.ObjectId;
import uz.jl.entity.Auditable;

import java.util.Date;

@Getter
@Setter
@Builder
public class Answer extends Auditable {
    private String text;
    private boolean isCorrect;
    private boolean selected;

    public Answer(ObjectId id, Date createdAt, Date updatedAt, boolean deleted) {
        super(id, createdAt, updatedAt, deleted);
    }
}
