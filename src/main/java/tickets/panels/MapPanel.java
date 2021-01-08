package tickets.panels;

import javax.swing.*;
import java.awt.*;

public class MapPanel extends JPanel
{
    public MapPanel()
    {
        JButton commencer = new JButton("Commencer la partie");
        this.add(commencer);
        commencer.addActionListener(e -> JOptionPane.showMessageDialog(null, "La partie commence, bonne chance"));
    }

    @Override
    protected void paintComponent( Graphics g )
    {
        ImageIcon image_background = new ImageIcon(getClass().getResource("/Map INFO.png"));
        g.drawImage(image_background.getImage(), 0, 0, getWidth(), getHeight(), this);
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, getWidth(), getHeight());
    }
}
