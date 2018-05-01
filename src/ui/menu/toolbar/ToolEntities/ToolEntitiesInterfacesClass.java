package ui.menu.toolbar.ToolEntities;

import javax.swing.*;

public class ToolEntitiesInterfacesClass implements Entities {

    private ToolEntities toolEntities;

    public ToolEntitiesInterfacesClass(ToolEntities toolEntities){
        this.toolEntities = toolEntities;
    }

    public JButton prepareButtonClass(){
        return toolEntities.prepareButtonInterfaceClass();
    }
}
