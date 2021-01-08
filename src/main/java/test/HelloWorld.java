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
        Road aa = new Road(AP4A, AP4B);

        Destination linearShort = new Destination(LO21, LP24);
        Destination linearMedium = new Destination(LP24, AP4A);
        Destination linearLong = new Destination(LP24, AP4B);

        System.out.println(linearShort.isComplete(List.of(aa, la, ll)));
        System.out.println(linearMedium.isComplete(List.of(aa, la, ll)));
        System.out.println(linearLong.isComplete(List.of(aa, la, ll)));
    }

}
