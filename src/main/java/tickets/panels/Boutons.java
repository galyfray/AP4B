package tickets.panels;

import tickets.Turn;
import tickets.uv.Credit;

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

        JMenu prendreUneRouteMenu = new JMenu("Prendre une route");
        //Faire un loop pour lister toutes les routes dispo en fonction du joueur
        JMenuItem route1 = new JMenuItem("Route 1");
        route1.addActionListener(e -> prendreUneRoute());
        prendreUneRouteMenu.add(route1);



        actions.add(prendreUneRouteMenu);
        //actions.add(prendreUneRouteBoutton);

        JMenu joueurEnCours = new JMenu("Infos joueur");
        this.add(joueurEnCours);

        JMenuItem affichageJoueur = new JMenuItem("Nom du joueur");
        joueurEnCours.add(affichageJoueur);

        JMenuItem creditsBouton = new JMenuItem("Crédits possédés : Afficher le nombre de crédits");
        joueurEnCours.add(creditsBouton);

        //Turn tour;
        //tour.getCurrentPlayer();

    }

    public void prendreUneRoute()
    {

        // Mettre à joueur actuel en fonction de la route qu'il prend.
    }

    public void passerSonTour()
    {
        // Mettre tous les boutons à jour:
        // - Infos joueur (Nom du joueur, Crédits du joueur)
    }
}
