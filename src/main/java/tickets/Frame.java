package tickets;

import tickets.panels.MapPanel;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame
{
    public static final Frame INSTANCE = new Frame();

    private Frame()
    {
    }

    public void build()
    {
        this.setName("Lancement");

        JLabel text = new JLabel("Bienvenue dans le menu de lancement des Aventuriers du Rail", JLabel.CENTER);
        this.add(text);

        JPanel startPanel = new JPanel();
        JButton btn1 = new JButton("Nouvelle partie");
        JButton btn2 = new JButton("Reprendre une partie en cours");

        startPanel.add(btn1);
        startPanel.add(btn2);

        MapPanel mapPanel = new MapPanel();

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
            Frame.INSTANCE.setContentPane(mapPanel);
            Frame.INSTANCE.pack();
        });
    }
}
