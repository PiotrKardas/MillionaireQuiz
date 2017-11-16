package milionerzy.model;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;


@Component
    public class QuestAnsw {
        private List<String> questionAnswers = new ArrayList<>();

        public QuestAnsw(){        }

    public List<String> getQuestionAnswers() {
        return questionAnswers;
    }

    public void addQuestionAnswer (Integer index, String answer) {questionAnswers.add(index,answer );}
}
