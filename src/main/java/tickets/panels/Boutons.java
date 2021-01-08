package tickets.panels;

import tickets.*;

import javax.swing.*;

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
            JMenuItem route1 = new JMenuItem("Route 1");
            route1.addActionListener(e -> prendreUneRoute());
            prendreUneRouteMenu.add(route1);
            /*for (Player joueur : PLAYERS)
            {
                joueur.ownedRoads
             }*/

        //joueurEnCours.update

        this.add(actions);
        actions.add(passerSonTourBoutton);
        this.add(joueurEnCours);
        joueurEnCours.add(affichageJoueur);
        actions.add(prendreUneRouteMenu);
        joueurEnCours.add(creditsBouton);
    }

    public void prendreUneRoute()
    {
        // Mettre à joueur actuel en fonction de la route qu'il prend.
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
