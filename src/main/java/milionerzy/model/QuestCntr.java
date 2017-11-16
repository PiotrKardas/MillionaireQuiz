package milionerzy.model;

import org.springframework.stereotype.Component;

@Component
public class QuestCntr {
    private Integer i = 0;

    public QuestCntr(){}

    public Integer getI() {
        return i;
    }

    public void setI(Integer i){
        this.i = i;
    }

    public void increment(){
        i++;
    }
}
