package ui.menu.toolbar.ToolEntities;

import javax.swing.*;

public class ToolEntitiesInheritRelation implements Entities {

    private ToolEntities toolEntities;

    public ToolEntitiesInheritRelation(ToolEntities toolEntities){
        this.toolEntities = toolEntities;
    }

    public JButton prepareButtonClass(){
        return toolEntities.prepareButtonInheritRelation();
    }
}
