package tickets;

import tickets.panels.Boutons;
import tickets.panels.MapPanel;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame
{
    public static final Frame INSTANCE = new Frame();
    public static final MapPanel MAP_PANEL = new MapPanel();

    private Frame()
    {
    }

    public void build()
    {
        this.setName("Lancement");

        JLabel text = new JLabel("Bienvenue dans le menu de lancement de Ticket To UTBM", JLabel.CENTER);
        this.add(text);

        JPanel startPanel = new JPanel();
        JButton btn1 = new JButton("Nouvelle partie");
        JButton btn2 = new JButton("Reprendre une partie en cours");

        startPanel.add(btn1);
        //startPanel.add(btn2);

        Boutons boutons = new Boutons();

        this.setLayout(new GridLayout(2, 1));
        this.getContentPane().add(startPanel);
        this.getContentPane().add(text);

        this.pack();
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btn1.addActionListener(e ->
        {
            System.out.println("called");
            Frame.INSTANCE.setContentPane(MAP_PANEL);
            Frame.INSTANCE.setJMenuBar(boutons);
            Dimension dim = Frame.INSTANCE.getSize();
            Frame.INSTANCE.pack();
            Frame.INSTANCE.setSize(dim);
        });
    }
}
