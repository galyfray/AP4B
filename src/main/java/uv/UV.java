package uv;

import java.util.Objects;

public class UV
{
    public final String name;

    public UV( String name )
    {
        this.name = name;

    }

    @Override
    public boolean equals( Object o )
    {
        if( this == o ) return true;
        if( o == null || getClass() != o.getClass() ) return false;
        UV uv = (UV) o;
        return Objects.equals(name, uv.name);
    }
}
