package tickets.panels;

import tickets.*;
import tickets.uv.Road;
import tickets.uv.Destination;

import javax.swing.*;

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

    /**
     * classe publique Boutons qui sert à générer les boutons en haut de la fenêtre.
     */
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
    /**
     * @param road route que le joueur choisi.
     * On va vérifier si le joueur peut prendre la route cliquée, et si oui on affiche la nouvelle
     * carte adaptée avec le choix de route. De même, on mettra toutes les infos à jour.
     */
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

    /**
     * Permet de passer son tour. On mettra à jour toutes les données nécessaires dans le menu pour le
     * prochain joueur. Aussi, on vérifiera si on est en fin de jeu ou non.
     */
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
        else
        {
            finDePartie();
        }
    }

    /**
     * Fonction de fin de partie qui s'active dès que le jeu se termine.
     * À ce moment là, on compte tous les points : routes prises + carte destinations terminées.
     */
    public void finDePartie()
    {
        String msgFinPartie = "Fin de partie !\n";
        for (Player joueur : tickets.Player.getPlayers())
        {
            for (Road route : joueur.ownedRoads)
            {
                if (route.cost == 2)
                {
                    joueur.score += 2;
                }
                else if (route.cost == 3)
                {
                    joueur.score += 4;
                }
            }
            for (Destination destinationtest : joueur.destinations)
            {
                if(destinationtest.isComplete(joueur.ownedRoads))
                {
                    joueur.score += 6;
                }
                else
                {
                    joueur.score -= 6;
                }
            }
            msgFinPartie += "Score de " + joueur.name + " : " + joueur.score + "\n";
        }
        JOptionPane.showMessageDialog(null, msgFinPartie);
    }
}
