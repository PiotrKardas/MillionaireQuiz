package milionerzy.model;

import org.springframework.stereotype.Component;

@Component
public class InitCheck {
    private boolean isInitialized = false;

    public InitCheck(){}

    public boolean isInitialized() {
        return isInitialized;
    }

    public void setInitialized(boolean initialized) {
        isInitialized = initialized;
    }
}
