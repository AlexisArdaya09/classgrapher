package ui.menu.toolbar.ToolEntities;

import javax.swing.*;

public class ToolEntitiesAggregationRelation implements Entities {

    private ToolEntities toolEntities;

    public ToolEntitiesAggregationRelation(ToolEntities toolEntities){
        this.toolEntities = toolEntities;
    }

    public JButton prepareButtonClass(){
        return toolEntities.prepareButtonAggregationRelation();
    }
}
