package tickets;

import java.util.List;

public class Turn
{
    public final List<Player> players;
    private int playerNumber;
    private int turnLeft = -1;

    public Turn( List<Player> players )
    {
        this.players = List.copyOf(players);
        playerNumber = 0;
    }

    public Player getCurrentPlayer()
    {
        return players.get(playerNumber);
    }

    public boolean next()
    {
        if( turnLeft == 0 )
        {
            return false;
        }
        if( getCurrentPlayer().getCreditSum() < 3 )
        {
            turnLeft = players.size();
        }

        playerNumber++;

        if( playerNumber > players.size() )
        {
            playerNumber = 0;
        }
        if( turnLeft > 0 )
        {
            turnLeft--;
        }
        return true;
    }

}
