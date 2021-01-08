package test;

import uv.Destination;
import uv.Road;
import uv.UV;

import java.util.List;

public class HelloWorld
{

    public static void main( String[] args )
    {
        UV LP24 = new UV("LP24"), LO21 = new UV("LO21"), AP4B = new UV("AP4B"), AP4A = new UV("AP4A");
        Road ll = new Road(LO21, LP24);
        Road la = new Road(LO21, AP4A);
        Road lab = new Road(LO21, AP4B);
        Road aa = new Road(AP4A, AP4B);
        Road al = new Road(AP4A, LP24);

        Destination linearLong = new Destination(LP24, AP4B);

        System.out.println(linearLong.isComplete(List.of(aa, ll)));

    }

}
