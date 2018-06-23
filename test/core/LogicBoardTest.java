package core;

import core.exception.ConnectorException;
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
    public void selectShape() {
    }

    @Test
    public void unSelectShape() {
    }

    @Test
    public void removeConnectorsFromSelectedShape() {
    }
}