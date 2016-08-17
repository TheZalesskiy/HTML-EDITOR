package listeners;



import view.View;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import java.awt.*;


/**
 * TextEditMenuListener class
 * 21.06.2016
 * Created by TheZalesskie
 */
public class TextEditMenuListener implements MenuListener {
    private View view;

    public TextEditMenuListener(View view) {
        this.view = view;

    }


    @Override
    public void menuSelected(MenuEvent e) {
        //From the passed parameter to get an object on which the action was carried out
        JMenu jMenu = (JMenu) e.getSource();
        //In the resulting menu to get the list of components
        Component[] components = jMenu.getMenuComponents();
        /**For each menu item to invoke a method setEnabled, passing as a parameter
        isHtmlTabSelected result of a call () method of presentation*/
        for (Component component : components){
            component.setEnabled(view.isHtmlTabSelected());
        }

    }

    @Override
    public void menuDeselected(MenuEvent e) {

    }

    @Override
    public void menuCanceled(MenuEvent e) {

    }
}
