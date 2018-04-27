package ui.menu.toolbar.ToolEntities;

import javax.swing.*;

public class ToolEntitiesRelation implements Entities {

    private ToolEntities toolEntities;

    public ToolEntitiesRelation(ToolEntities toolEntities){
        this.toolEntities = toolEntities;
    }

    public JButton prepareButtonClass(){
        return toolEntities.prepareButtonRelation();
    }
}
