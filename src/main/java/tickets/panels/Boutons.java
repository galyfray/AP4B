package tickets.panels;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Boutons extends JMenuBar
{
    public Boutons()
    {
        JMenu actions = new JMenu("Actions");
        this.add(actions);

        JMenuItem passerSonTourBoutton = new JMenuItem("Passer son tour");
        actions.add(passerSonTourBoutton);
        passerSonTourBoutton.addActionListener(e -> System.out.println("Bonjour!"));

        JMenuItem prendreUneRouteBoutton = new JMenuItem("Prendre une route");
        actions.add(prendreUneRouteBoutton);
    }
}
