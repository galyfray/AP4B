package tickets.panels;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MapPanel extends JPanel
{
    public final ArrayList<ImageIcon> images = new ArrayList<>();

    public MapPanel()
    {
        images.add(new ImageIcon(getClass().getResource("/Map INFO.png")));
    }

    @Override
    protected void paintComponent( Graphics g )
    {
        for( ImageIcon image : images )
        {
            g.drawImage(image.getImage(), 0, 0, getWidth(), getHeight(), this);
        }
    }
}
