package actions;



import view.View;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * UndoAction class
 * 21.06.2016
 * Created by TheZalesskie
 */
public class UndoAction extends AbstractAction {
    private View view;

    public UndoAction(View view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        view.undo();

    }
}
