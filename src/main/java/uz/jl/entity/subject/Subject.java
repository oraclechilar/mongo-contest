package uz.jl.entity.subject;

import lombok.*;
import org.bson.types.ObjectId;
import uz.jl.entity.Auditable;
import uz.jl.entity.test.Test;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
public class Subject extends Auditable {
    private String name;
    private List<Test> tests;


    public Subject(ObjectId id, Date createdAt, Date updatedAt, boolean deleted, String name, List<Test> tests) {
        super(id, createdAt, updatedAt, deleted);
        this.name = name;
        this.tests = tests;
    }
}
