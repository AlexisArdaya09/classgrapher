package ui.canvas;

import core.LogicBoard;
import core.Point;
import entities.classes.NormalClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CanvasTest {

    @Test
    public void testUndo() {
        NormalClass classA = new NormalClass("main", new Point(0, 0), new Point(20, 20));
        LogicBoard logicBoard = new LogicBoard();
        Canvas canvas = new Canvas(logicBoard);
        logicBoard.shapes.add(classA);
        canvas.addMemento();
        canvas.undo();
        assertEquals(0, logicBoard.shapes.size());
    }

    @Test
    public void redo() {
    }
}