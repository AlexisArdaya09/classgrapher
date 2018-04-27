package ui.menu.toolbar.ToolEntities;

import javax.swing.*;

public class ToolEntitiesAbstractClass implements Entities {

    private ToolEntities toolEntities;

    public ToolEntitiesAbstractClass(ToolEntities toolEntities){
        this.toolEntities = toolEntities;
    }

    public JButton prepareButtonClass(){
        return toolEntities.prepareButtonAbstractClass();
    }
}
