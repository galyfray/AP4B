package tickets.panels;

import tickets.*;
import tickets.uv.Road;

import javax.swing.*;
import java.util.ArrayList;

import static tickets.Main.ROADS;

public class Boutons extends JMenuBar
{
    public Turn turn = new Turn(tickets.Player.getPlayers());
    public JMenu actions = new JMenu("Actions");
    public JMenuItem passerSonTourBoutton = new JMenuItem("Passer son tour");
    public JMenu prendreUneRouteMenu = new JMenu("Prendre une route");
    public JMenu joueurEnCours = new JMenu("Infos joueur");
    public String nomDuJoueurEnCours = turn.getCurrentPlayer().name;
    public JMenuItem affichageJoueur = new JMenuItem(nomDuJoueurEnCours);
    public String CreditsPossedes = "Crédits possédés : " + turn.getCurrentPlayer().getCreditSum();
    public JMenuItem creditsBouton = new JMenuItem(CreditsPossedes);

    public Boutons()
    {

        passerSonTourBoutton.addActionListener(e -> passerSonTour());

        //Faire un loop pour lister toutes les routes dispo en fonction du joueur
            /*for (Player joueur : PLAYERS)
            {
                joueur.ownedRoads
             }*/

        // Initialisation des boutons routes


        for (Road route : ROADS)
        {
            String boutonTextRoute = "Route de " + route.start.name + " à " + route.end.name;
            JMenuItem boutonRoute = new JMenuItem(boutonTextRoute);
            boutonRoute.addActionListener(e -> prendreUneRoute(route));
            prendreUneRouteMenu.add(boutonRoute);
        }

        this.add(actions);
        actions.add(passerSonTourBoutton);
        this.add(joueurEnCours);
        joueurEnCours.add(affichageJoueur);
        actions.add(prendreUneRouteMenu);
        joueurEnCours.add(creditsBouton);
    }

    public void prendreUneRoute(Road road)
    {
        Player player = turn.getCurrentPlayer();
        if( player.removeCredits(road.type, road.cost) && !Player.getAllOwnedRoad().contains(road) )
        {
            player.ownedRoads.add(road);
            Frame.MAP_PANEL.images.add(road.imageIcon);
            Frame.INSTANCE.repaint();
        }
    }

    public void passerSonTour()
    {
        if (turn.next())
        {
            nomDuJoueurEnCours = turn.getCurrentPlayer().name;
            affichageJoueur.setText(nomDuJoueurEnCours);

            CreditsPossedes = "Crédits possédés : " + turn.getCurrentPlayer().getCreditSum();
            creditsBouton.setText(CreditsPossedes);
        }
        // Mettre tous les boutons à jour:
        // - Infos joueur (Nom du joueur, Crédits du joueur)
    }
}
