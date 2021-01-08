package tickets;

import tickets.uv.Credit;
import tickets.uv.Road;

import java.util.HashMap;
import java.util.HashSet;

public class Player
{
    public final String name;
    public final HashSet<Road> ownedRoads = new HashSet<>();
    private final HashMap<Credit, Integer> credits = new HashMap<>();

    public Player( String name )
    {
        this.name = name;
    }

    public void addCredits( Credit type, int number )
    {
        credits.put(type, credits.get(type) + number);
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

    public boolean hasCredits( Credit type, int number )
    {
        return credits.get(type) >= number;
    }
}
