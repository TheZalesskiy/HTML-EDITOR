package listeners;

import view.View;
import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

/**
 * This listener will follow the menu , and if specifically,
 * for the moment when the editing menu will be selected by the user
 */
public class UndoMenuListener implements MenuListener {

    private View view;
    private JMenuItem undoMenuItem;     //cancel
    private JMenuItem redoMenuItem;     //return

    //constructor
    public UndoMenuListener(View view, JMenuItem undoMenuItem, JMenuItem redoMenuItem) {
        this.view = view;
        this.undoMenuItem = undoMenuItem;
        this.redoMenuItem = redoMenuItem;
    }

    @Override
    public void menuSelected(MenuEvent menuEvent) {
        //can ask the presentation we cancel
        undoMenuItem.setEnabled(view.canUndo());
        redoMenuItem.setEnabled(view.canRedo());
    }

    @Override
    public void menuDeselected(MenuEvent menuEvent) {

    }

    @Override
    public void menuCanceled(MenuEvent menuEvent) {

    }

}
