package core.memento;

import core.LogicBoard;
import entities.memento.Memento;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by Wilson Rolando Crespo Omonte on 25/04/2018.
 */
public class MementoObjectHandler {
    public MementoObjectHandler() {
    }
    public static Object copyObject(Object object) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(object);
            objectOutputStream.flush();

            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            return objectInputStream.readObject();
        } catch (Exception e) {
            System.out.println("An error occurred whiel trying to copy this object: " + object);
            return null;
        }
    }

    public static LogicBoard loadObject(Memento memento) {
        return (LogicBoard) copyObject(memento.getState());
    }
}
