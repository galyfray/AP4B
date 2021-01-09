package tickets.panels;

import tickets.*;
import tickets.uv.Credit;
import tickets.uv.Road;
import tickets.uv.Destination;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

import static tickets.Main.ROADS;

public class Boutons extends JMenuBar
{
    public Turn turn = new Turn(tickets.Player.getPlayers());
    public JMenu actions = new JMenu("Actions");
    public JMenuItem passerSonTourBoutton = new JMenuItem("Passer son tour");
    public JMenu prendreUneRouteMenu = new JMenu("Prendre une route");
    public JMenu joueurEnCours = new JMenu("Infos joueur");
    public JMenu destinationsBoutton = new JMenu ("Destinations");

    public String nomDuJoueurEnCours = turn.getCurrentPlayer().name;
    public JMenuItem affichageJoueur = new JMenuItem(nomDuJoueurEnCours);
    public String AffichageCredits = "Credits du joueur : " + turn.getCurrentPlayer().getCredits();
    public JMenuItem creditsBouton = new JMenuItem(AffichageCredits);
    public String RoutesPrises = "Aucune route prise pour le moment.";
    public JMenuItem RoutesPrisesBouton = new JMenuItem(RoutesPrises);
    public String AffichageDestinations = "Destination du joueur : ";
    public JMenuItem destinationsSousBoutton = new JMenuItem(AffichageDestinations);

    public Boutons()
    {

        passerSonTourBoutton.addActionListener(e -> passerSonTour());

        for (Road route : ROADS)
        {
            String boutonTextRoute = "Route de " + route.start.name + " a " + route.end.name;
            JMenuItem boutonRoute = new JMenuItem(boutonTextRoute);
            boutonRoute.addActionListener(e -> prendreUneRoute(route));
            prendreUneRouteMenu.add(boutonRoute);
        }

        for(Destination destination : turn.getCurrentPlayer().destinations)
        {
            AffichageDestinations += destination.start.name + " a " + destination.end.name;
        }
        destinationsSousBoutton.setText(AffichageDestinations);

        this.add(actions);
        actions.add(passerSonTourBoutton);
        this.add(joueurEnCours);
        this.add(destinationsBoutton);
        destinationsBoutton.add(destinationsSousBoutton);
        joueurEnCours.add(affichageJoueur);
        actions.add(prendreUneRouteMenu);
        joueurEnCours.add(creditsBouton);
        joueurEnCours.add(RoutesPrisesBouton);
    }

    public void prendreUneRoute(Road road)
    {
        Player player = turn.getCurrentPlayer();
        if( player.removeCredits(road.type, road.cost) && !Player.getAllOwnedRoad().contains(road) )
        {
            player.ownedRoads.add(road);
            Frame.MAP_PANEL.images.add(road.imageIcon);
            Frame.INSTANCE.repaint();
            AffichageCredits = "Credits du joueur : " + turn.getCurrentPlayer().getCredits();
            creditsBouton.setText(AffichageCredits);

            if (!turn.getCurrentPlayer().ownedRoads.isEmpty())
            {
                RoutesPrises = "Routes prises : ";
                for(Road route : turn.getCurrentPlayer().ownedRoads)
                {
                    RoutesPrises += route.start.name + "-" + route.end.name + "   ";
                }
            }
            else
            {
                RoutesPrises = "Aucune route prise pour le moment.";
            }
            RoutesPrisesBouton.setText(RoutesPrises);
        }
    }

    public void passerSonTour()
    {
        if (turn.next())
        {
            nomDuJoueurEnCours = turn.getCurrentPlayer().name;
            affichageJoueur.setText(nomDuJoueurEnCours);

            AffichageCredits = "Credits du joueur : " + turn.getCurrentPlayer().getCredits();
            creditsBouton.setText(AffichageCredits);

            if (!turn.getCurrentPlayer().ownedRoads.isEmpty())
            {
                RoutesPrises = "Routes prises : ";
                for(Road route : turn.getCurrentPlayer().ownedRoads)
                {
                    RoutesPrises += route.start.name + "-" + route.end.name + ",";
                }
            }
            else
            {
                RoutesPrises = "Aucune route prise pour le moment.";
            }
            RoutesPrisesBouton.setText(RoutesPrises);

            for(Destination destination : turn.getCurrentPlayer().destinations)
            {
                AffichageDestinations = "Destination du joueur : " + destination.start.name + " a " + destination.end.name;
            }
            destinationsSousBoutton.setText(AffichageDestinations);
        }
        // Mettre tous les boutons à jour:
        // - Infos joueur (Nom du joueur, Crédits du joueur)
    }
}
