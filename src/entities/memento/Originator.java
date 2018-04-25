package entities.memento;

/**
 * Created by Wilson Rolando Crespo Omonte on 25/04/2018.
 */
public interface Originator {
    Memento getMemento();
    void setMemento(Memento memento);
}
