package tickets.uv;

import tickets.utils.Pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Destination
{
    public final UV start, end;

    public Destination( UV start, UV end )
    {
        this.start = start;
        this.end = end;
    }

    /**
     * @param roads set of roads that should be used to check if the two UVs are linked.
     * @return true if destination's UVs are linked false otherwise.
     */
    public boolean isComplete( Set<Road> roads )
    {
        ArrayList<Road> startList = new ArrayList<>();
        ArrayList<Road> endList = new ArrayList<>();

        for( Road road : roads )
        {
            if( road.contain(start) )
            {
                startList.add(road);
            }
            if( road.contain(end) )
            {
                endList.add(road);
            }

        }

        //check if a road simply link te two UVs
        if( startList.stream().anyMatch((endList::contains)) )
        {
            return true;
        }

        ArrayList<UV> checked = new ArrayList<>();
        checked.add(start);

        HashSet<UV> linkedUV = new HashSet<>();

        for( Road road : startList )
        {
            linkedUV.add(road.start);
            linkedUV.add(road.end);
        }

        linkedUV.removeAll(checked);

        Pair<Boolean, ArrayList<UV>> pair;

        for( UV uv : linkedUV )
        {
            if( checked.contains(uv) )
            {
                continue;
            }
            Destination des = new Destination(uv, end);
            pair = des.partialComplete(roads, checked);
            if( pair.first )
            {
                return true;
            } else
            {
                checked = pair.second;
            }
        }
        return false;

    }

    private Pair<Boolean, ArrayList<UV>> partialComplete( Set<Road> roads, ArrayList<UV> checked )
    {
        ArrayList<Road> startList = new ArrayList<>();
        ArrayList<Road> endList = new ArrayList<>();

        for( Road road : roads )
        {
            if( road.containAny(checked) ) //we skip any UVs we already checked for to avoid loop
            {
                continue;
            }
            if( road.contain(start) )
            {
                startList.add(road);
            }
            if( road.contain(end) )
            {
                endList.add(road);
            }

        }

        //check if a road simply link te two UVs
        if( startList.stream().anyMatch((endList::contains)) )
        {
            return new Pair<>(true, checked);
        }

        checked.add(start);

        HashSet<UV> linkedUV = new HashSet<>();

        for( Road road : startList )
        {
            linkedUV.add(road.start);
            linkedUV.add(road.end);
        }

        linkedUV.removeAll(checked);

        Pair<Boolean, ArrayList<UV>> pair;

        for( UV uv : linkedUV )
        {
            if( checked.contains(uv) )
            {
                continue;
            }
            Destination des = new Destination(uv, end);
            pair = des.partialComplete(roads, checked);
            if( pair.first )
            {
                return new Pair<>(true, checked);
            } else
            {
                checked = pair.second;
            }
        }

        return new Pair<>(false, checked);

    }
}
