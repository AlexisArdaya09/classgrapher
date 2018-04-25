package entities.memento;

import java.util.Vector;

/**
 * Created by Wilson Rolando Crespo Omonte on 25/04/2018.
 */
public class CareTaker {
    private Vector<Memento> statuses;
    private int iterator;

    public CareTaker() {
        statuses = new Vector<>();
        iterator = -1;
    }

    public Memento undo() {
        return iterator > 0 ? statuses.get(--iterator) : null;
    }

    public Memento redo() {
        return iterator < (statuses.size() - 1) ? statuses.get(++iterator) : null;
    }
}
