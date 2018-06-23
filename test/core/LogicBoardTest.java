package core;

import core.exception.CanNotBeCreatedException;
import core.exception.ConnectorException;
import entities.classes.AbstractClass;
import entities.classes.BaseClass;
import entities.classes.NormalClass;
import entities.relations.NormalRelation;
import org.junit.Test;

import static org.junit.Assert.*;

public class LogicBoardTest {

    @Test
    public void testAddOneConnectorToLogicBoard() throws ConnectorException {
        NormalClass classA = new NormalClass("main", new Point(0,0), new Point(20,20));

        NormalClass classB = new NormalClass("two", new Point(30,30), new Point(50,50));
        NormalRelation normalRelation = new NormalRelation(new Point(20,20), new Point(30,30));
        Connector connector = new Connector(classA, classB, normalRelation);
        LogicBoard logicBoard = new LogicBoard();
        logicBoard.addConnector(connector);
        assertEquals(1,logicBoard.connectors.size());
    }

    @Test
    public void testNoneSelectShape() {
        Point point = new Point(15,35);
        LogicBoard logicBoard = new LogicBoard();
        logicBoard.selectShape(point);
        assertNull("No deberia existir una figura en lienzo vacio",logicBoard.getSelectedShape());
    }

    @Test
    public void testIfSelectShape() {
        Point point = new Point(0,0);
        NormalClass classA = new NormalClass("main", new Point(0,0), new Point(20,20));
        LogicBoard logicBoard = new LogicBoard();
        logicBoard.shapes.add(classA);
        logicBoard.selectShape(point);
        assertNotNull(logicBoard.getSelectedShape());
    }

    @Test
    public void testUnSelectShape() {
        LogicBoard logicBoard = new LogicBoard();
        logicBoard.unSelectShape();
        assertNull("No deberia existir una figura seleccionada",logicBoard.getSelectedShape());
    }

    @Test
    public void testRemoveConnectorsFromSelectedShape() throws ConnectorException {
        NormalClass classA = new NormalClass("main", new Point(0,0), new Point(20,20));

        NormalClass classB = new NormalClass("two", new Point(30,30), new Point(50,50));
        NormalRelation normalRelation = new NormalRelation(new Point(20,20), new Point(30,30));
        Connector connector = new Connector(classA, classB, normalRelation);
        LogicBoard logicBoard = new LogicBoard();
        logicBoard.shapes.add(classA);
        logicBoard.shapes.add(classB);
        logicBoard.addConnector(connector);
        logicBoard.selectShape(new Point(1,1));
        logicBoard.removeConnectorsFromSelectedShape();
        assertEquals(0,logicBoard.connectors.size());
    }

    @Test
    public void testAdditionOfAbstractClass() throws CanNotBeCreatedException {
        LogicBoard logicBoard = new LogicBoard();
        logicBoard.currentTool = Tool.ABSTRACT_CLASS;
        Point point = new Point(20,20);
        Shape newShape = (Shape) BaseClass.getNewBaseClass(logicBoard.currentTool, "", point);
        logicBoard.shapes.add(newShape);
        assertEquals("entities.classes.AbstractClass",logicBoard.getShape(point).get().getClass().getName());
    }
}