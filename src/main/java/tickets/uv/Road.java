package tickets.uv;

import javax.swing.*;
import java.util.List;
import java.util.Objects;

public class Road
{
    public final UV start, end;
    public final Credit type;
    public final int cost;
    public final ImageIcon imageIcon;

    public Road( UV start, UV end, Credit type, int cost, ImageIcon imageIcon )
    {
        this.end = end;
        this.start = start;
        this.type = type;
        this.cost = cost;
        this.imageIcon = imageIcon;
    }

    public boolean contain( UV uv )
    {
        return uv.equals(start) || uv.equals(end);
    }

    public boolean containAny( List<UV> uvs )
    {
        return uvs.contains(start) || uvs.contains(end);
    }

    @Override
    public boolean equals( Object o )
    {
        if( this == o ) return true;
        if( o == null || getClass() != o.getClass() ) return false;
        Road road = (Road) o;
        return Objects.equals(start, road.start) && Objects.equals(end, road.end);
    }
}
