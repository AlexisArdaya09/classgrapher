package ui.menu.toolbar.ToolEntities;

import javax.swing.*;

public class ToolEntitiesClass implements Entities {
    private ToolEntities toolEntities;

    public ToolEntitiesClass(ToolEntities toolEntities){
        this.toolEntities = toolEntities;
    }

    public JButton prepareButtonClass(){
        return toolEntities.prepareButtonClass();
    }
}
