import java.util.*;
class Generuj               //klasa testowa, oraz zawieraj¹ca w sobie algorytmy, z niej startujemy.
{
    Kolejka k = new Kolejka(); //instancja
    public void generujProcesy(int ilosc, int maxdlProces, int maxmomentZglosz)
    {
        int iloscProc=ilosc;
        int max=maxdlProces;
        int maxM=maxmomentZglosz;
        if(iloscProc<0)
        {
            iloscProc=0;
        }
        if(max<1)
        {
            max=1;
        }
        if(maxM<1)
        {
            maxM=1;
        }
        if(max<maxM)
        {
            maxM=max-1;
        }
        Random r = new Random();
        for(int i=0; i<=iloscProc; i++)
        {
            int dlugosc = r.nextInt(max);
            int moment = r.nextInt(maxM);
            int numer=i+1;
            Proces pr = new Proces(dlugosc, numer, moment); 
            if(i==iloscProc)
            {
                Proces em = new Proces(0, 0, 0);
                k.dodajProces(em);
            }
            else{
                k.dodajProces(pr);
            }
        }
                    
    }
    public void wypiszProcesy()
    {
        k.wypiszProcesy();
    }
    public int dlKolejki()
    {
        return k.dlugoscKolejki();
    }
    public int sredniCzasFCSF()
    {
        int t=0;
        for(int i=0; i<k.dlugoscKolejki()-1;i++)
        {
            t+=k.getProces(i).getCzas() - k.getProces(i+1).getMoment();
        }
        return t/(k.dlugoscKolejki()-1);
    }
    public int sredniRot()
    {
        int kwantCzasu=100; //ustalamy kwant czasu.
        int t=0;
        ArrayList<Proces> rot = new ArrayList<Proces>();
        int zp=0;
        for(int i=0; i<k.dlugoscKolejki(); i++)
        {
            Proces r = new Proces(k.getProces(i).getCzas(), k.getProces(i).getNumer(), k.getProces(i).getMoment());
            rot.add(r);
        }








        for(int j=0; zp<k.dlugoscKolejki()-1; j++)
        {
           if(kwantCzasu>rot.get(j).getMoment())
           {
            if(j<k.dlugoscKolejki()-1)
           {
               if(rot.get(j).czyWyk()!=true)
                {
                    if(kwantCzasu>rot.get(j).getCzas())
                    {
                        t+=rot.get(j).getCzas();
                        rot.get(j).setWyk(kwantCzasu);
                        zp++;
                    }
                    else{
                         t+=kwantCzasu;
                         rot.get(j).setWyk(kwantCzasu);
                    }
                }
                else{
                    zp++;
                }
           }
           else{
               j=0;
            }
        }


            else{
               if(j<k.dlugoscKolejki()-1)
                    {
                    if(rot.get(j).czyWyk()!=true)
                    {
                        if(kwantCzasu>rot.get(j).getCzas())
                        {
                            t+=rot.get(j).getCzas()+rot.get(j).getMoment();
                            rot.get(j).setWyk(kwantCzasu);
                            zp++;
                        }
                        else{
                            t+=kwantCzasu+rot.get(j).getMoment();
                            rot.get(j).setWyk(kwantCzasu);
                        }
                    }
                    else{
                        zp++;
                    }
                }
                else{
                    j=0;
                }
            }
        }
        return t/(k.dlugoscKolejki()-1);
    }

    public int sredniSJF()
    {
        int t=0;
        //ArrayList<Proces> sjf = new ArrayList<Proces>();
        boolean zp=false;
        for(int i=0; i<k.dlugoscKolejki()-1;i++)
        {   
            if(i==0)
            {
                if(k.getProces(i+1).getMoment()==0)
                {
                    if(k.getProces(i).getCzas()<k.getProces(i+1).getCzas())
                    {
                        t+=k.getProces(i).getCzas();
                        k.usunProces(i);
                    }
                    else{
                        if(k.getProces(i).getCzas()>k.getProces(i+1).getCzas())
                        {
                            t+=k.getProces(i+1).getCzas();
                            k.usunProces(i+1);
                        }
                        else{
                            t+=k.getProces(i).getCzas();
                            k.usunProces(i);
                        }
                    }
                }
                else{
                    t+=k.getProces(i).getCzas()-k.getProces(i+1).getMoment();
                    k.usunProces(i);
                }
            }
            else{ 
                if(zp==false)
                {
                    Collections.sort(k.kolejka, new comparator());
                    zp=true;
                }
                t+=k.getProces(i).getCzas()-k.getProces(i+1).getMoment();
            }
        }
        return t/k.dlugoscKolejki();
    }
    public static void main(String [] args)
    {
        Generuj gen = new Generuj();
        gen.generujProcesy(100, 1000, 200); //ustalamy parametry symulacji (ilosc procesow, maksymalna d³ugoœæ procesu, maksymalny czas Pojawienia siê procesu, od pojawienia siê wczeœniejszego procesu)
        //gen.wypiszProcesy();  // wypisuje wszystkie procesy
        System.out.println("Sredni czas dla FCFS: "+gen.sredniCzasFCSF());
        System.out.println("Sredni czas dla RR: "+gen.sredniRot());
        System.out.println("Sredni czas dla SJF: "+gen.sredniSJF());
    }
  
}
    
