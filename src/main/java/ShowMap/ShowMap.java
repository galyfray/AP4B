package ShowMap;

import java.awt.Graphics;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

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
   public void paint(Graphics g){
        Image img1 = Toolkit.getDefaultToolkit().getImage("D:/Paul/UTBM/Cours/INFO/BR01-A2020/AP4B/aled/AP4B Project/Map INFO.png");
        g.drawImage(img1, 0, 0, this);

        Image img2 = Toolkit.getDefaultToolkit().getImage("D:/Paul/UTBM/Cours/INFO/BR01-A2020/AP4B/aled/AP4B Project/R1-rouge.png");
        g.drawImage(img2, 0, 0, this);

    }

    public static void main(String[] args){

        JFrame carte = new JFrame("Carte de la partie");
        carte.getContentPane().add(new ShowMap());
        carte.setSize(1280,720);
        carte.setVisible(true);
        carte.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
}

