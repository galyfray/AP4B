package tickets;

import tickets.uv.Credit;
import tickets.uv.Destination;
import tickets.uv.Road;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Player
{
    public final String name;
    public final HashSet<Road> ownedRoads = new HashSet<>();
    private final HashMap<Credit, Integer> credits = new HashMap<>();
    private static final ArrayList<Player> PLAYERS = new ArrayList<>();
    public final HashSet<Destination> destinations = new HashSet<>();

    public Player( String name )
    {
        this.name = name;
        PLAYERS.add(this);
    }

    public void addCredits( Credit type, int number )
    {
        credits.put(type, credits.getOrDefault(type, 0) + number);
    }

    public boolean removeCredits( Credit type, int number )
    {
        if( !hasCredits(type, number) )
        {
            return false;
        }
        credits.put(type, credits.get(type) - number);
        return true;
    }

    public int getCreditSum()
    {
        int sum = 0;
        for( int i : credits.values() )
        {
            sum += i;
        }
        return sum;
    }

    public static List<Road> getAllOwnedRoad()
    {
        ArrayList<Road> roads = new ArrayList<>();
        for( Player p : PLAYERS )
        {
            roads.addAll(p.ownedRoads);
        }
        return roads;
    }

    public static List<Player> getPlayers()
    {
        return List.copyOf(PLAYERS);
    }

    public boolean hasCredits( Credit type, int number )
    {
        return credits.getOrDefault(type, 0) >= number;
    }
}
