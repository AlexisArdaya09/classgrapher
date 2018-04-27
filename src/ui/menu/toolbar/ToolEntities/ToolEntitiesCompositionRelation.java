package ui.menu.toolbar.ToolEntities;

import javax.swing.*;

public class ToolEntitiesCompositionRelation implements Entities {

    private ToolEntities toolEntities;

    public ToolEntitiesCompositionRelation(ToolEntities toolEntities){
        this.toolEntities = toolEntities;
    }

    public JButton prepareButtonClass(){
        return toolEntities.prepareButtonCompositionRelation();
    }
}
