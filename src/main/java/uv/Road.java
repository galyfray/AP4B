package uv;

import java.util.List;
import java.util.Objects;

public class Road
{
    public final UV start, end;

    public Road( UV start, UV end )
    {
        this.end = end;
        this.start = start;
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
