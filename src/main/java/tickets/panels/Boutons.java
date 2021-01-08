package tickets.panels;

import javax.swing.*;
import java.awt.*;

public class Boutons extends JMenuBar
{
    public Boutons()
    {
        JMenu menu = new JMenu("Jouer");
        JMenuItem m1 = new JMenuItem("MenuItem1");
        menu.add(m1);

        this.add(menu);
    }
}
