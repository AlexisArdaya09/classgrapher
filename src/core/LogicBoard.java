package core;

import core.memento.MementoObjectHandler;
import entities.memento.Memento;
import entities.memento.Originator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LogicBoard implements Serializable, Originator {
  private static final int SELECTED_SHAPE_BORDER_COLOR = -16776961;
  private static final int BLACK_BORDER_COLOR = -16777216;
  public List<Connector> connectors = new ArrayList<>(0);
  public List<Shape> shapes = new ArrayList<>(0);

  public Shape getSelectedShape() {
    return selectedShape;
  }

  private Shape selectedShape;
  public Tool currentTool = Tool.ANY;
  private Stack<Shape> deletedShapes = new Stack<>();

  public void addConnector(Connector connector) {
    this.connectors.add(connector);
  }

  public void clean() {
    this.shapes.clear();
    this.connectors.clear();
  }

  public Optional<Shape> getShape(Point point) {
    return shapes.stream().filter(shape ->
        shape.getShapeInCoordinate(point).isPresent()).findFirst();
  }

  public void selectShape(Point point){
    Optional<Shape> shape = this.getShape(point);
    if(shape.isPresent()){
      this.selectedShape= shape.get();
      this.selectedShape.setBorderColor(SELECTED_SHAPE_BORDER_COLOR);
    }
  }

  public void unSelectShape(){
      if (this.selectedShape != null){
          this.selectedShape.setBorderColor(BLACK_BORDER_COLOR);
      }
      this.selectedShape = null;
  }

  public void removeSelectedShape(){
    this.shapes.remove(this.selectedShape);
    this.unSelectShape();
  }

  public void removeConnectorsFromSelectedShape(){
    if (this.selectedShape !=null){
      removeConnectorFormClassA();
      removeConnectorFromClassB();
   }
  }

  private void removeConnectorFromClassB() {
    List<Connector> connectors_to_be_deleted2 = this.connectors.stream().filter(connector -> connector.getClassB().equals(this.selectedShape)).collect(Collectors.toList());
    connectors_to_be_deleted2.forEach(connector -> {
      this.shapes.remove(connector.getRelation());
      this.connectors.remove(connector);
    });
  }

  private void removeConnectorFormClassA() {
    List<Connector> connectors_to_be_deleted = this.connectors.stream().filter(connector -> connector.getClassA().equals(this.selectedShape)).collect(Collectors.toList());
    connectors_to_be_deleted.forEach(connector -> {
      this.shapes.remove(connector.getRelation());
      this.connectors.remove(connector);
    });
  }

  @Override
  public Memento getMemento() {
    return new Memento(MementoObjectHandler.copyObject(this));
  }

  @Override
  public void setMemento(Memento memento) {
    LogicBoard logicBoardCopy = MementoObjectHandler.loadObject(memento);
    setFields(logicBoardCopy);
  }

  private void setFields(LogicBoard logicBoard) {
    this.connectors = logicBoard.connectors;
    this.shapes = logicBoard.shapes;
    this.currentTool = logicBoard.currentTool;
    this.deletedShapes = logicBoard.deletedShapes;
  }
}
