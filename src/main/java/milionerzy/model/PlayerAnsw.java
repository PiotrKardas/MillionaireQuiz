package milionerzy.model;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
    public class PlayerAnsw {
        private List<String> userAnswers = new ArrayList<>();

    public PlayerAnsw() {
    }

    public List<String> getUserAnswers() {
        return userAnswers;
    }

    public void addUserAnswer (Integer index, String userAnswer){
        userAnswers.add(index, userAnswer);
    }
}
