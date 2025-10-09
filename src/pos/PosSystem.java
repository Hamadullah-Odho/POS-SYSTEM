package pos;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.Insets;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import view.LoginView;

public class PosSystem {

    public static void main(String[] args)throws UnsupportedLookAndFeelException {
    
        UIManager.setLookAndFeel(new FlatLightLaf());
        
        UIManager.put("Component.background", Color.WHITE);
        UIManager.put("PasswordField.background", Color.WHITE);
        UIManager.put("TextField.background", Color.WHITE);
        UIManager.put("Component.arc", 15);
        UIManager.put("TextComponent.arc", 15);
        UIManager.put("TextField.selectionBackground", new Color(153,51,255));
        UIManager.put("TextField.margin", new Insets(0,15,0,15));
        
        UIManager.put("Button.background", Color.WHITE);
        UIManager.put("Button.arc", 10);
        UIManager.put("Button.margin", new Insets(0, 15, 0, 15));
        
        UIManager.put("Button.hoverBackground",new Color(153,51,255));
        UIManager.put("Button.PressedBackground",new Color(153,0,153));
        new LoginView().setVisible(true);
        

        
        
    }
}
