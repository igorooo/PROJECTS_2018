import java.util.*;
class comparator implements Comparator<Proces> //comparator, kt�ry w razie potrzeby szereguje liste proces�w.
{
    public int compare(Proces p1, Proces p2)
    {
        if(p1.getCzas()<p2.getCzas())
        {
            return 1;
        }
        else{
            if(p1.getCzas()>p2.getCzas())
            {
                return -1;
            }
            else{
                if(p1.getNumer()<p2.getNumer())
                {
                    return 1;
                }
                else{
                    return -1;
                }
            }
        }
    }
}