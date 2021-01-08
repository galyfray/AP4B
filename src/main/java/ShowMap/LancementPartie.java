package ShowMap;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class LancementPartie extends JPanel implements ActionListener
{


    public static void main( String[] args )
    {

        JFrame presentation = new JFrame("Lancement");

        JLabel text = new JLabel("Bienvenue dans le menu de lancement des Aventuriers du Rail",JLabel.CENTER);
        presentation.add(text);

        JPanel panel1 = new JPanel();
        JButton btn1 = new JButton("Nouvelle partie");
        JButton btn2 = new JButton("Reprendre une partie en cours");

        panel1.add(btn1);
        panel1.add(btn2);

        ShowMap carte = new ShowMap();
        ShowMap map = new ShowMap();
        map.map();


        presentation.setLayout(new GridLayout(2, 1));
        presentation.add(panel1);
        presentation.add(text);

        presentation.pack();
        presentation.setBounds(500,400,1280,720);
        presentation.setVisible(true);
        presentation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        btn1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                carte.setVisible(true);
                presentation.setVisible(false);
            }

        });

    }

    @Override
    public void actionPerformed( ActionEvent actionEvent )
    {

    }
}

