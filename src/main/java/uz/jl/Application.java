package uz.jl;

import uz.jl.entity.test.Test;
import uz.jl.mappers.test.TestMapper;
import uz.jl.repository.test.TestRepository;
import uz.jl.services.test.TestService;
import uz.jl.ui.TestUI;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Application {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger("org.mongodb.driver");
        logger.setLevel(Level.SEVERE);
        new TestUI(new TestService(new TestRepository(Test.class), new TestMapper())).delete();
    }
}
