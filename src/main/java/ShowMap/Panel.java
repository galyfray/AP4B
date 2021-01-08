package ShowMap;

import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComponent;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel extends JPanel
{
    Panel()
    {
        JButton commencer = new JButton("Commencer la partie");
        this.add(commencer);

        commencer.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed( ActionEvent e )
            {
                JOptionPane.showMessageDialog(null,"La partie commence, bonne chance");
            }
        });

    }

    @Override
    protected void paintComponent( Graphics g )
    {

        ImageIcon image_background = new ImageIcon(getClass().getResource("D:/Paul/UTBM/Cours/INFO/BR01-A2020/AP4B/aled/AP4B Project/Map INFO.png"));
        g.drawImage(image_background.getImage(), 0, 0, getWidth(), getHeight(), this);
    }
}
