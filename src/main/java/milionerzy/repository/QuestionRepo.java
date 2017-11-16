package milionerzy.repository;

import milionerzy.model.Question;
import org.springframework.data.repository.CrudRepository;


public interface QuestionRepo extends CrudRepository<Question, Long> {
    Question getQuestionById(Long id);
    }



