package listeners;

import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import javax.swing.undo.UndoableEdit;

/**
 * UndoListener class
 * This class will follow the edits that you can undo or redo
 * 16.08.2016
 * Created by TheZalesskie
 */
public class UndoListener implements UndoableEditListener {
    private UndoManager undoManager;

    //construcnor
    public UndoListener(UndoManager undoManager) {
        this.undoManager = undoManager;
    }

    //should be transferred from the events receive edit and add it to undoManager.
    @Override
    public void undoableEditHappened(UndoableEditEvent e) {
//        UndoableEdit edit = e.getEdit();
//        undoManager.addEdit(edit);
        undoManager.addEdit(e.getEdit());

    }


}
