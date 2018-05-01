package entities.memento;

/**
 * Created by Wilson Rolando Crespo Omonte on 25/04/2018.
 */
public class Memento {
    private Object state;

    public Memento(Object state) {
        this.state = state;
    }

    public Object getState() {
        return state;
    }

    public void setState(Object state) {
        this.state = state;
    }
}
