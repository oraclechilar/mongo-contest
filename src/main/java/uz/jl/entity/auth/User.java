package uz.jl.entity.auth;

import lombok.*;
import org.bson.types.ObjectId;
import uz.jl.entity.Auditable;
import uz.jl.entity.quiz.Quiz;

import java.util.List;

@Getter
@Setter
@Builder
public class User extends Auditable {
    private String username;
    private String password;
    private String email;
    private List<Quiz> quizzes;

}
