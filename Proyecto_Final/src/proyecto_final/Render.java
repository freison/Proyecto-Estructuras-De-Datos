
package proyecto_final;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import vistas.PnProyecto;

public class Render extends DefaultListCellRenderer implements ListCellRenderer<Object>{

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        PnProyecto pn = (PnProyecto) value;
        setText(pn.getName());
        
        return this;
    }
}
