package ui.menu.toolbar.ToolEntities;

import javax.swing.*;

public class ToolEntitiesInterfaceRelation implements Entities {

    private ToolEntities toolEntities;

    public ToolEntitiesInterfaceRelation(ToolEntities toolEntities){
        this.toolEntities = toolEntities;
    }

    public JButton prepareButtonClass(){
        return toolEntities.prepareButtonInheritRelation();
    }
}
