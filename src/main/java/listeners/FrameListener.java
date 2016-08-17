package listeners;



import view.View;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * FrameListener class
 * date: 14.06.2016
 *
 * @autor TheZalesskie
 */
public class FrameListener extends WindowAdapter {
    private View view;

    public FrameListener(View view) {
        this.view = view;
    }

    public void windowClosing(WindowEvent windowEvent){
        view.exit();
    }
}
