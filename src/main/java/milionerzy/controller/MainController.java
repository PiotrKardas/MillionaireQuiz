package milionerzy.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import milionerzy.data.QuestionData;
import milionerzy.model.*;
import milionerzy.repository.QuestionRepo;

@Controller
public class MainController {

    @Autowired
    private QuestCntr questCntr;

    @Autowired
    private InitCheck initCheck;

    @Autowired
    private QuestionRepo questionRepo;

    @Autowired
    private QuestAnsw questAnsw;

    @Autowired
    private PlayerAnsw playerAnsw;

    @GetMapping("/")
    public String index() {

    questCntr.setI(0);

    if (!initCheck.isInitialized()){
    Question question = new Question();
    question.setQuestion(QuestionData.questions[0]);
    question.setAnswer(QuestionData.answers[0]);
    questionRepo.save(question);

     Question question1 = new Question();
     question1.setQuestion(QuestionData.questions[1]);
     question1.setAnswer(QuestionData.answers[1]);
     questionRepo.save(question1);

     Question question2 = new Question();
     question2.setQuestion(QuestionData.questions[2]);
     question2.setAnswer(QuestionData.answers[2]);
     questionRepo.save(question2);

     Question question3 = new Question();
     question3.setQuestion(QuestionData.questions[3]);
     question3.setAnswer(QuestionData.answers[3]);
     questionRepo.save(question3);

     Question question4 = new Question();
     question4.setQuestion(QuestionData.questions[4]);
     question4.setAnswer(QuestionData.answers[4]);
     questionRepo.save(question4);

     Question question5 = new Question();
     question5.setQuestion(QuestionData.questions[5]);
     question5.setAnswer(QuestionData.answers[5]);
     questionRepo.save(question5);

     initCheck.setInitialized(true);
    }
       return "index";
    }

        @GetMapping("/init")
                public String initialize(ModelMap modelMap){
        questCntr.increment();
            Question q = questionRepo.getQuestionById(new Long(questCntr.getI()));
        questAnsw.addQuestionAnswer(questCntr.getI()-1, q.getAnswer());
        modelMap.put("question", q.getQuestion());
        return "questions";
        }

        @GetMapping("/question")
        public String question (@RequestParam String answer, ModelMap modelMap){
            playerAnsw.addUserAnswer(questCntr.getI() -1, answer);
         questCntr.increment();
            if (questCntr.getI()==(QuestionData.amountOfQuestions+1)){
                int amountOfCorrect=0;
                int correctPercentage=0;
                String message = null;

                for(int i = 0; i< QuestionData.amountOfQuestions; i++){
                    if (playerAnsw.getUserAnswers().get(i).equals(questAnsw.getQuestionAnswers().get(i))){
                        amountOfCorrect++;
                    }
                }

                correctPercentage = (int)((double)amountOfCorrect / QuestionData.amountOfQuestions*100);

                if(correctPercentage == 100){
                    message = "zdobyłeś maksymalna liczbę punktów";
                }
                modelMap.put("amountOfCorrect", amountOfCorrect);
                modelMap.put ("correctPrecentage", correctPercentage);
                modelMap.put("message", message);
                return "result";
                }

            Question q = questionRepo.getQuestionById(new Long(questCntr.getI()));
            questAnsw.addQuestionAnswer(questCntr.getI()-1, q.getAnswer());
            modelMap.put("question", q.getQuestion());
            return "questions";
            }

    @GetMapping("/end")
    public String end (){
        return "end";
    }
}
