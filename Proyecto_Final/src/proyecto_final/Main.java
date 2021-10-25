
package proyecto_final;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import vistas.FrmLogin;

public class Main {

    public static void main(String[] args) {
        loadMainForm();
    }
    
    public static void loadMainForm(){
        FrmLogin login = new FrmLogin();
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login.setLocationRelativeTo(null);
        login.setVisible(true);
    }
}
