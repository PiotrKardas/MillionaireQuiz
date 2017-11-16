package milionerzy.model;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
    public class AnswCntr {
    private List<String> answers = new ArrayList<>();

    public AnswCntr() {}

    public List<String> getAnswers(){
        return answers;}

    public void addAnswer(String answer){
        answers.add(answer);
    }
}
