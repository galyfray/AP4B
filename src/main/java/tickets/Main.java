package tickets;

import tickets.uv.Credit;
import tickets.uv.Destination;
import tickets.uv.Road;
import tickets.uv.UV;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static final ArrayList<UV> UVS = new ArrayList<>();
    public static final ArrayList<Destination> DESTINATIONS = new ArrayList<>();
    public static final ArrayList<Road> ROADS = new ArrayList<>();

    public static void main( String[] args )
    {

        UV RE = new UV("RE4E"), IA = new UV("IA41"), SY = new UV("SY41"), AP = new UV("AP4A"), RS = new UV("RS40"), ST = new UV("STAGE"), IT = new UV("IT43");
        UVS.addAll(List.of(RE, IA, SY, AP, RS, ST, IT));

        Road IR = new Road(IT, RE, Credit.CS, 2, new ImageIcon(Main.class.getResource("/Route_Rouge_Gauche.png"))),
                RI = new Road(RE, IA, Credit.TM, 2, new ImageIcon(Main.class.getResource("/Route_Bleue_Haut.png"))),
                IS = new Road(IA, SY, Credit.EC, 3, new ImageIcon(Main.class.getResource("/Route_Verte_Haut.png"))),
                SA = new Road(SY, AP, Credit.QC, 2, new ImageIcon(Main.class.getResource("/Route_Rose.png"))),
                AI = new Road(AP, IT, Credit.TM, 3, new ImageIcon(Main.class.getResource("/Route_Bleue_Bas.png"))),
                ITS = new Road(IT, ST, Credit.EC, 2, new ImageIcon(Main.class.getResource("/Route_Verte_Bas.png"))),
                STA = new Road(ST, AP, Credit.CS, 2, new ImageIcon(Main.class.getResource("/Route_Rouge_Milieu.png"))),
                STR = new Road(ST, RS, Credit.OM, 3, new ImageIcon(Main.class.getResource("/Route_Jaune.png"))),
                RSY = new Road(RS, SY, Credit.CS, 3, new ImageIcon(Main.class.getResource("/Route_Rouge_Droite.png")));
        ROADS.addAll(List.of(IR, RI, IS, SA, AI, ITS, STA, STR, RSY));

        Destination dest1 = new Destination(IT, SY), dest2 = new Destination(SY, RE);
        DESTINATIONS.addAll(List.of(dest1, dest2));

        Player p1 = new Player("Joueur 1"), p2 = new Player("Joueur 2");

        p1.addCredits(Credit.CS, 4);
        p2.addCredits(Credit.CS, 3);

        p1.addCredits(Credit.TM, 2);
        p2.addCredits(Credit.TM, 3);

        p1.addCredits(Credit.EC, 3);
        p2.addCredits(Credit.EC, 2);

        p1.addCredits(Credit.OM, 3);
        p2.addCredits(Credit.QC, 2);

        Frame.INSTANCE.build();

    }
}
