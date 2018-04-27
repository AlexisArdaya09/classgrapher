package ui.menu.toolbar.ToolEntities;

import core.LogicBoard;
import core.Tool;
import ui.menu.toolbar.ToolBar;

import javax.swing.*;

public class ToolEntities {

    private LogicBoard logicBoard;

    public ToolEntities(LogicBoard logicBoard){
        this.logicBoard = logicBoard;
    }


    public JButton prepareButtonClass(){
        return ToolBar.getButton("/resource/class.png",
                e -> logicBoard.currentTool = logicBoard.currentTool == Tool.CLASS
                        ? Tool.ANY : Tool.CLASS);
    }

    public JButton prepareButtonAbstractClass() {

        return ToolBar.getButton("/resource/abstract.png",
                e -> logicBoard.currentTool = logicBoard.currentTool == Tool.ABSTRACT_CLASS
                        ? Tool.ANY : Tool.ABSTRACT_CLASS);
    }

    public JButton prepareButtonInterfaceClass() {
        return ToolBar.getButton("/resource/interfaceClass.png",
                e -> logicBoard.currentTool = logicBoard.currentTool == Tool.INTERFACE_CLASS
                        ? Tool.ANY : Tool.INTERFACE_CLASS);
    }

    public JButton prepareButtonRelation() {
        return ToolBar.getButton("/resource/association.png",
                e -> logicBoard.currentTool = logicBoard.currentTool == Tool.RELATION
                        ? Tool.ANY : Tool.RELATION);
    }

    public JButton prepareButtonInheritRelation() {
        return ToolBar.getButton("/resource/inherit.png",
                e -> logicBoard.currentTool = logicBoard.currentTool == Tool.INHERIT_RELATION
                        ? Tool.ANY : Tool.INHERIT_RELATION);
    }

    public JButton prepareButtonInterfaceRelation() {
        return ToolBar.getButton("/resource/interface.png",
                e -> logicBoard.currentTool = logicBoard.currentTool == Tool.INTERFACE_RELATION
                        ? Tool.ANY : Tool.INTERFACE_RELATION);
    }

    public JButton prepareButtonAggregationRelation() {
        return ToolBar.getButton("/resource/aggregation.png",
                e -> logicBoard.currentTool = logicBoard.currentTool == Tool.AGGREGATION_RELATION
                        ? Tool.ANY : Tool.AGGREGATION_RELATION);
    }

    public JButton prepareButtonCompositionRelation() {
        return ToolBar.getButton("/resource/composition.png",
                e -> logicBoard.currentTool = logicBoard.currentTool == Tool.COMPOSITION_RELATION
                        ? Tool.ANY : Tool.COMPOSITION_RELATION);
    }
}
