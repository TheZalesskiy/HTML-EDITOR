package listeners;



import view.View;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;



/**
 * Created by TheZalesskie on 16.06.2016.
 * This class will listen and process changes the state of the tab bar
 */
public class TabbedPaneChangeListener implements ChangeListener {

    private View view;


    public TabbedPaneChangeListener(View view) {
        this.view = view;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        view.selectedTabChanged();
    }
}
