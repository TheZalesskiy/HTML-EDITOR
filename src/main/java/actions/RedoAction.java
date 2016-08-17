package actions;



import view.View;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * RedoAction class
 * 21.06.2016
 * Created by TheZalesskie
 */
public class RedoAction extends AbstractAction {
    private View view;
    public RedoAction(View view){
        this.view = view;

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        view.redo();

    }


}
