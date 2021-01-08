package ShowMap;

import java.awt.Graphics;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComponent;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

/*
public class ShowMap extends JPanel
{
    private Image image;

    public ShowMap( Image i )
    {
        image = i;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int height = this.getSize().height;
        int width = this.getSize().width;
        g.drawImage(image,0,0,415, 272, this);
    }
}

    private void jButtonSuivanteClicked(java.awt.event.MouseEvent evt)
    {
        java.awt.Toolkit toolkit = java.awt.Toolkit.getDefaultToolkit();
        java.net.URL url = getClass().getResource("D:\\yoda.jpg");
        Image image = toolkit.getImage(url);
        ShowMap jPanelImage = new ShowMap(image);
        getContentPane().add(jPanelImage);
    }

public class ShowMap {

    public static void main(String[] args)
    {
        JFrame F = new JFrame("Carte de la Partie");
        F.setVisible(true);
        F.addWindowListener(new gestionFenetre());
        ImageIcon icone = new ImageIcon("D:/Paul/UTBM/Cours/INFO/BR01-A2020/AP4B/aled/AP4B Project/test.png");
        JLabel image = new JLabel(icone);
        F.setSize(icone.getIconWidth(), icone.getIconHeight());
        F.add(image);
        F.setVisible(true);
    }
}
class gestionFenetre extends WindowAdapter{
    public void windowClosing(WindowEvent e){
        System.exit(0);
    }
}
*/


public class ShowMap extends JPanel
{
    /*
    public void paint( Graphics g )
    {
        Image img1 = Toolkit.getDefaultToolkit().getImage("D:/Paul/UTBM/Cours/INFO/BR01-A2020/AP4B/aled/AP4B Project/Map INFO.png");
        g.drawImage(img1, 0, 0, this);


        //  Image img2 = Toolkit.getDefaultToolkit().getImage("D:/Paul/UTBM/Cours/INFO/BR01-A2020/AP4B/aled/AP4B Project/R1-rouge.png");
        // g.drawImage(img2, 0, 0, this);

    }
*/        public void map()
        {

            JFrame lancement = new JFrame("Preparation");
            // lancement.getContentPane().add(new ShowMap());

            lancement.setBounds(500, 400, 1280, 720);
            lancement.setVisible(true);
            lancement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JPanel panel2 = new JPanel();

            JLabel annonce = new JLabel("Voici la carte de la partie," +
                    " le joueur qui a le plus grand nombre de routes a la fin gagne la partie." +
                    "Vous commencez avec le meme nombre de wagons et le but est d'en placer un maximum", JLabel.CENTER);

            lancement.add(annonce);
            JButton btnok = new JButton("D'accord");
            btnok.setSize(1, 1);
            lancement.setLayout(new GridLayout(2, 1));
            panel2.add(btnok);
            lancement.add(panel2);

            btnok.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed( ActionEvent e )
                {

                    JFrame carte = new JFrame("Carte de la partie");
                    carte.getContentPane().add(new ShowMap());
                    carte.getContentPane().add(new Panel());

                    carte.setBounds(500, 400, 1280, 720);
                    carte.setVisible(true);

                    JPanel panelmap = new JPanel();

                    carte.add(panelmap);

                    carte.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                }
            });





        }
}



