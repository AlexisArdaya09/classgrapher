package ui.canvas;

import core.*;
import core.exception.CanNotBeCreatedException;
import core.exception.ConnectorException;
import entities.classes.BaseClass;
import entities.relations.Relation;
import ui.forms.FormInput;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CanvasListener implements MouseListener, MouseMotionListener {
    private static final int double_click = 2;
    private Canvas canvas;
    private Optional<Shape> currentShape = Optional.empty();
    private Tool currentRelation = Tool.RELATION;
    private int selection = 0;
    private String cancelOption = "cancel.OPTION";

    public CanvasListener(Canvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        java.awt.Point point = e.getPoint();

        if (ToolUtils.isToolRelation(canvas.logicBoard.currentTool)) {
            execRelation(point);
            return;
        }

        Point pointPressed = new Point(point.x, point.y);
        currentShape = canvas.getShape(pointPressed);

        if (!currentShape.isPresent() && ToolUtils.isToolClass(canvas.logicBoard.currentTool)) {
            try {
                Shape newShape = (Shape) BaseClass.getNewBaseClass(canvas.logicBoard.currentTool, "", pointPressed);
                addShapeToLogicBoard(newShape);
                String title = createShapeTitle();

                if (!title.equals(cancelOption)) {
                    List<Shape> shapes = canvas.logicBoard.shapes;
                    canvas.logicBoard.shapes = shapes.stream().map(shape -> {
                        if (shape.getId().equals(newShape.getId())) {
                            return (Shape) ((BaseClass) newShape).setTitle(title);
                        }
                        return shape;
                    }).collect(Collectors.toList());
                    canvas.repaint();
                    return;
                }
                canvas.logicBoard.shapes.remove(newShape);
                canvas.repaint();
            } catch (CanNotBeCreatedException e1) {
                e1.printStackTrace();
            }
        }
        updateSelectedShape(pointPressed);
    }
    private void updateSelectedShape(Point pointPressed) {
        canvas.logicBoard.unSelectShape();
        if (currentShape.isPresent()) {
            canvas.logicBoard.selectShape(pointPressed);
        }
        canvas.repaint();
    }

    private void addShapeToLogicBoard(Shape shape) {
        canvas.logicBoard.shapes.add(shape);
        canvas.addMemento();
        canvas.logicBoard.currentTool = Tool.ANY;
        canvas.repaint();
    }

    private String createShapeTitle() throws CanNotBeCreatedException {
        return FormInput.getNameFromInput();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        boolean isToolRelation = canvas.logicBoard.currentTool == Tool.RELATION;
        boolean isToolInheritRelation = canvas.logicBoard.currentTool == Tool.INHERIT_RELATION;
        boolean isToolInterfaceRelation = canvas.logicBoard.currentTool == Tool.INTERFACE_RELATION;
        boolean isToolAggregationRelation = canvas.logicBoard.currentTool == Tool.AGGREGATION_RELATION;
        boolean isToolCompositionRelation = canvas.logicBoard.currentTool == Tool.COMPOSITION_RELATION;
        if (!isToolRelation && !isToolInheritRelation && !isToolInterfaceRelation
                && !isToolAggregationRelation && !isToolCompositionRelation) {
            if (currentShape.isPresent() && !isTargetClassSelected()) {
                canvas.addMemento();
            }
            currentShape = Optional.empty();
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (SwingUtilities.isRightMouseButton(e)) {
            java.awt.Point point = e.getPoint();
            List<Shape> shapes = canvas.logicBoard.shapes;
            currentShape.ifPresent(currentShape ->
                    canvas.logicBoard.shapes = shapes.stream().map(shape -> {
                        if (shape.getId().equals(currentShape.getId())) {
                            try {
                                shape.addPoint(new Point(point.x, point.y));

                            } catch (Exception ea) {
                                System.out.print(ea.getMessage());
                            }
                            return shape;
                        }
                        return shape;
                    }).collect(Collectors.toList()));
            canvas.repaint();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == double_click) {
            java.awt.Point point = e.getPoint();
            currentShape = canvas.getShape(new Point(point.x, point.y));
            currentShape.ifPresent(cs -> {
                canvas.logicBoard.shapes = getCollectShapes(cs);
                canvas.repaint();
            });
        }
    }

    public List<Shape> getCollectShapes(Shape cs) {
        return canvas.logicBoard.shapes.stream().map(s -> {
            if (s.getId().equals(cs.getId())) {
                Shape selectedShape = s;
                String title = FormInput.getNameFromInput();
                if (!title.equals(cancelOption)) {
                    selectedShape = (Shape) ((BaseClass) s).setTitle(title);
                }
                return selectedShape;
            }
            return s;
        }).collect(Collectors.toList());
    }

    private void execRelation(java.awt.Point point) {
        if (isOriginClassSelected()) {
            markOriginClassAsCurrentShape(point);
            canvas.initFollowerLine(point);
            return;
        }
        if (isTargetClassSelected()) {
            createConnectorToTargetClass(point);
            canvas.destroyFollowerLine();
        }
    }

    private void createConnectorToTargetClass(java.awt.Point point) {
        canvas.getShape(new Point(point.x, point.y)).ifPresent(shape -> {
            try {
                Connector connector;
                connector = new Connector(
                        (BaseClass) currentShape.get(),
                        (BaseClass) shape,
                        Relation.getNewRelation(currentRelation));

                canvas.logicBoard.addConnector(connector);
                canvas.logicBoard.shapes.add((Shape) connector.getRelation());
            } catch (ConnectorException | CanNotBeCreatedException e1) {
                e1.printStackTrace();
            }

            selection = 0;
            canvas.logicBoard.currentTool = Tool.ANY;
            canvas.repaint();
        });
    }

    private void markOriginClassAsCurrentShape(java.awt.Point point) {
        currentRelation = canvas.logicBoard.currentTool;
        canvas.getShape(new Point(point.x, point.y)).ifPresent(shape -> {
            currentShape = Optional.of(shape);
            selection++;
        });
    }

    private boolean isTargetClassSelected() {
        return selection == 1;
    }

    private boolean isOriginClassSelected() {
        return selection == 0;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if (canvas.getStartingPoint() != null && canvas.getEndPoint() != null) {
            canvas.setEndPoint(e.getPoint());
            canvas.paintFollowerLine(canvas.getGraphics());
        }
    }
}
