import java.util.*;
class Kolejka           //Wiele metod nie zosta�o urzytych, ale pozostawi�em je, gdyby trzeba by�o co� edytowa�, albo doda�.
{
    ArrayList<Proces> kolejka= new ArrayList<Proces>();   //kolejka proces�w
    public void dodajProces(Proces proces)
    {
        kolejka.add(proces);
    }
    public void dodajProcesIn(int index, Proces proces)
    {
        kolejka.add(index, proces);
    }
    public void wyczyscKolejke()
    {
        kolejka.clear();
    }
    public Proces getProces(int index)
    {
        return kolejka.get(index);
    }
    public boolean czyPusta()
    {
        return kolejka.isEmpty();
    }
    public void usunProces(int index)
    {
        kolejka.remove(index);
    }
    public void setProces(int index, Proces proces)
    {
        kolejka.set(index, proces);
    }
    public int dlugoscKolejki()
    {
        return kolejka.size();
    }
    public void wypiszProcesy()
    {
        for(int i=0; i<dlugoscKolejki()-1; i++)
        {
            System.out.println("Dlugosc zycia: "+getProces(i).getCzas()+" Moment przybycia: "+getProces(i).getMoment()+" Numer procesu: " +getProces(i).getNumer());
        }
    }
}