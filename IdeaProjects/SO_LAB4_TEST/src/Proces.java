import java.util.*;
public class Proces
{
    int liczbaStron;
    ArrayList<Integer> odw;
    int bitPom;
    int bitPom2;
    public Proces(int liczbaStron, ArrayList<Integer> odw, int bitPom, int bitPom2)
    {
        this.liczbaStron=liczbaStron;
        this.odw=odw;
        this.bitPom=bitPom;
        this.bitPom2=bitPom2;
    }
    public int get(int i)
    {
        return odw.get(i);
    }
}