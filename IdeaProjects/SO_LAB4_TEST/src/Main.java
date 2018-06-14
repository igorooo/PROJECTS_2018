import java.util.*;
public class Main
{
    Random r = new Random();
    static int liczbaRamek=100;
    static int liczbaProcesow=10;
    static int iloscOdwolan=1000;
    static int maxProg=2;
    static int minProg=-15;
    static int oknoZbioruR=8;
    static int zrSize=20;
    ArrayList<Proces> procesy = new ArrayList<Proces>();
    ArrayList<PamiecFizyczna> ramki = new ArrayList<PamiecFizyczna>();
    ArrayList<Integer> przydz = new ArrayList<Integer>();
    public void dodajProcesy()
    {
        for(int i=0; i<liczbaProcesow; i++)
        {
             int liczbaStron=r.nextInt(10)+5;
             ArrayList<Integer> odwolania = new ArrayList<Integer>();
             for(int j=0; j<iloscOdwolan; j++)
             {
                 odwolania.add(r.nextInt(liczbaStron)+1);
             }
             procesy.add( new Proces(liczbaStron, odwolania, 0, 0) );
        }
        init();
    }
    public void init()
    {
        PamiecFizyczna pam = new PamiecFizyczna(0, 0);
        for(int i =0; i<liczbaRamek; i++)
        {
            ramki.add(pam);
        }
    }
    public void clear()
    {
        PamiecFizyczna mem = new PamiecFizyczna(0, 0);
        for(int i=0; i<liczbaRamek; i++)
        {
            ramki.set(i, mem);
        }
    }
    public Proces getp(int i)
    {
        return procesy.get(i);
    }
    public void przydzialRowny()
    {
         for(int i=0; i<liczbaProcesow;i++)
         {
             int p= liczbaRamek/liczbaProcesow;
             przydz.add(p);
         }
    }
    public void przydzialProporcjonalny()
    {
        int suma=0;
        for(int i=0;i<liczbaProcesow; i++)
        {
            suma+=getp(i).liczbaStron;
        }
        for(int j=0;j<liczbaProcesow;j++)
        {
            double p=(getp(j).liczbaStron*liczbaRamek)/suma;
            przydz.add((int)p);
        }
    }
    public void LRUdlaRiP()
    {
        int przydzial=przydz.get(0);
        int przedzialA=0;
        int przedzialB=przydzial;
        int sumaB=0;
        for(int i=0;i<liczbaProcesow;i++)
        {
            int brakStron=0;
            boolean czyWyk=false;
            if(i!=0)
            {
                przydzial=przydz.get(i);
                przedzialA=przedzialB;
                przedzialB+=przydzial;
            }
            for(int j=0;j<iloscOdwolan;j++)
            {
                for(int p=przedzialA;p<przedzialB&&!czyWyk;p++)
                {
                    if(getp(i).get(j)==ramki.get(p).wartosc)
                    {
                        PamiecFizyczna mem = new PamiecFizyczna(getp(i).get(j), 0);
                        ramki.set(p, mem);
                        for(int k=0; k<przedzialB;k++)
                        {
                            if(getp(i).get(j)!=ramki.get(k).wartosc)
                            {
                                int zp1=ramki.get(k).wartosc;
                                int zp2=ramki.get(k).bitPom;
                                PamiecFizyczna pam = new PamiecFizyczna(zp1, (zp2)+1);
                                ramki.set(k, pam);
                            }
                        }
                        czyWyk=true;
                    }
                    if(ramki.get(p).wartosc==0)
                    {
                        PamiecFizyczna mem2 = new PamiecFizyczna(getp(i).get(j), 0);
                        ramki.set(p, mem2);
                        brakStron++;
                        czyWyk=true;
                    }
                }
                if(czyWyk==false)
                {
                    int zp3=0;
                    int index=0;
                    for(int l=0; l<przedzialB; l++)
                    {
                        if(ramki.get(l).bitPom>zp3)
                        {
                            zp3=ramki.get(l).bitPom;
                            index=l;
                        }
                    }
                    PamiecFizyczna mem3 = new PamiecFizyczna(getp(i).get(j), 0);
                    ramki.set(index, mem3);
                    brakStron++;
                }
                czyWyk=false;
            }
            System.out.println("Dla procesu numer "+(i+1)+" który posiada "+getp(i).liczbaStron+" stron i otrzymał "+przydzial+" ramek "+ " wystąpiło "+brakStron+" braków stron.");
            sumaB+=brakStron;
        } 
        System.out.println("W sumie "+sumaB+" błędów braku stron");
        przydz.clear();
        clear();
    }
    public void LRUdlaSLIB()
    {
        int sumaB=0;
          for(int i=0;i<liczbaProcesow;i++)
          {
            int przydzialPocz=10;
            int bit=0;
            int bit2=0;
            int brakStron=0;
            boolean czyWyk=false;
            for(int j=0;j<iloscOdwolan;j++)
            {
                if(procesy.get(i).bitPom>=maxProg)
                {
                    przydzialPocz++;
                    bit=0;
                    //bit2=0;
                    Proces pr = new Proces(procesy.get(i).liczbaStron, procesy.get(i).odw, bit, bit2);
                    procesy.set(i, pr); 
                    PamiecFizyczna mem = new PamiecFizyczna(0, 0);
                    ramki.set(przydzialPocz, mem);
                }
                if(procesy.get(i).bitPom2<=minProg)
                {
                    przydzialPocz--;
                    bit2=0;
                    //bit=0;
                    Proces pr = new Proces(procesy.get(i).liczbaStron, procesy.get(i).odw, bit, bit2);
                    procesy.set(i, pr);
                    PamiecFizyczna mem = new PamiecFizyczna(0, 0);
                    ramki.set(przydzialPocz+1, mem);
                }
                for(int p=0;p<przydzialPocz&&!czyWyk;p++)
                {
                    if(getp(i).get(j)==ramki.get(p).wartosc)
                    {
                        bit2--;
                        //System.out.println("Ilosc stron dla procesu wynosi: "+getp(i).liczbaStron+" Bit1 wynosi "+bit+" bit2 wynosi: "+bit2+" a przedział "+przydzialPocz);
                        Proces pr = new Proces(procesy.get(i).liczbaStron, procesy.get(i).odw, bit, bit2);
                        procesy.set(i, pr);
                        PamiecFizyczna mem = new PamiecFizyczna(getp(i).get(j), 0);
                        ramki.set(p, mem);
                        for(int k=0; k<przydzialPocz;k++)
                        {
                            if(getp(i).get(j)!=ramki.get(k).wartosc)
                            {
                                int zp1=ramki.get(k).wartosc;
                                int zp2=ramki.get(k).bitPom;
                                PamiecFizyczna pam = new PamiecFizyczna(zp1, (zp2)+1);
                                ramki.set(k, pam);
                            }
                        }
                        czyWyk=true;
                    }
                    if(ramki.get(p).wartosc==0)
                    {
                        bit++;
                        //System.out.println("Ilosc stron dla procesu wynosi: "+getp(i).liczbaStron+" Bit1 wynosi "+bit+" bit2 wynosi: "+bit2+" a przedział "+przydzialPocz);
                        Proces pr = new Proces(procesy.get(i).liczbaStron, procesy.get(i).odw, bit, bit2);
                        procesy.set(i, pr);
                        PamiecFizyczna mem2 = new PamiecFizyczna(getp(i).get(j), 0);
                        ramki.set(p, mem2);
                        brakStron++;
                        czyWyk=true;
                    }
                }
                if(czyWyk==false)
                {
                    int zp3=0;
                    int index=0;
                    for(int l=0; l<przydzialPocz; l++)
                    {
                        if(ramki.get(l).bitPom>zp3)
                        {
                            zp3=ramki.get(l).bitPom;
                            index=l;
                        }
                    }
                    bit++;
                    //System.out.println("Ilosc stron dla procesu wynosi: "+getp(i).liczbaStron+" Bit1 wynosi "+bit+" bit2 wynosi: "+bit2+" a przedział "+przydzialPocz);
                    Proces pr = new Proces(procesy.get(i).liczbaStron, procesy.get(i).odw, bit, bit2);
                    procesy.set(i, pr);
                    PamiecFizyczna mem3 = new PamiecFizyczna(getp(i).get(j), 0);
                    ramki.set(index, mem3);
                    brakStron++;
                }
                czyWyk=false;
            }
            System.out.println("Dla procesu numer "+(i+1)+" który posiada "+getp(i).liczbaStron+" stron, wystąpiło "+brakStron+" braków stron.");
            sumaB+=brakStron;
            clear();
        }
        System.out.println("W sumie "+sumaB+" błędów braku stron");
        przydz.clear();
    }
    public void LRUdlaMS()
    {
        int sumaB=0;
        for(int i=0;i<liczbaProcesow;i++)
        {
            int brakStron=0;
            boolean czyWyk=false;
            ArrayList<Integer> zr = new ArrayList<Integer>();
            ArrayList<Integer> iloscR = new ArrayList<Integer>();
            int iloscPrzydz=iloscOdwolan/zrSize;
            int przydz=0;
            int przydz2=zrSize;
            for(int ilePrzydz=0;ilePrzydz<iloscPrzydz;ilePrzydz++)
            {
                for(int j=przydz;j<przydz2;j++)
                {
                    if(zr.size()==0)
                    {
                        zr.add(getp(i).get(j));
                    }
                    else{
                        boolean czyZna=false;
                        for(int k=0;k<zr.size();k++)
                        {
                             if(zr.get(k)==getp(i).get(j))
                             {
                                 czyZna=true;
                                 break;
                             }
                        }
                        if(czyZna==false)
                        {
                            zr.add(getp(i).get(j));
                        }
                    }
                }
                iloscR.add(zr.size());
                zr.clear();
                przydz+=zrSize;
                przydz2+=zrSize;
            }
            int hp=0;
            int hp2=0;
            przydz=0;
            przydz2=iloscR.get(hp2);
            for(int j=0; j<iloscOdwolan;j++)
            {
                if(hp>zrSize)
                {
                    hp=0;
                    hp2++;
                    przydz=iloscR.get(hp2);
                }
                for(int p=0;p<przydz&&!czyWyk;p++)
                {
                    if(getp(i).get(j)==ramki.get(p).wartosc)
                    {
                        PamiecFizyczna mem = new PamiecFizyczna(getp(i).get(j), 0);
                        ramki.set(p, mem);
                        for(int k=0; k<przydz2;k++)
                        {
                            if(getp(i).get(j)!=ramki.get(k).wartosc)
                            {
                                int zp1=ramki.get(k).wartosc;
                                int zp2=ramki.get(k).bitPom;
                                PamiecFizyczna pam = new PamiecFizyczna(zp1, (zp2)+1);
                                ramki.set(k, pam);
                            }
                        }
                        czyWyk=true;
                    }
                    if(ramki.get(p).wartosc==0)
                    {
                        PamiecFizyczna mem2 = new PamiecFizyczna(getp(i).get(j), 0);
                        ramki.set(p, mem2);
                        brakStron++;
                        czyWyk=true;
                    }
                }
                if(czyWyk==false)
                {
                    int zp3=0;
                    int index=0;
                    for(int l=0; l<przydz2; l++)
                    {
                        if(ramki.get(l).bitPom>zp3)
                        {
                            zp3=ramki.get(l).bitPom;
                            index=l;
                        }
                    }
                    PamiecFizyczna mem3 = new PamiecFizyczna(getp(i).get(j), 0);
                    ramki.set(index, mem3);
                    brakStron++;
                }
                czyWyk=false;
                hp++;
            }
            System.out.println("Dla procesu numer "+(i+1)+" który posiada "+getp(i).liczbaStron+" stron, wystąpiło "+brakStron+" braków stron.");
            sumaB+=brakStron;
            clear();
        }
        System.out.println("W sumie "+sumaB+" błędów braku stron");
        przydz.clear();
    }
    public static void main(String [] args)
    {
        Main m = new Main();
        m.dodajProcesy();
        System.out.println("Przydział równy: ");
        m.przydzialRowny();
        m.LRUdlaRiP();
        System.out.println("Przydział proporcjonalny: ");
        m.przydzialProporcjonalny();
        m.LRUdlaRiP();
        System.out.println("Sterowanie częstością błędów braku stron: ");
        m.LRUdlaSLIB();
        System.out.println("Model strefowy: ");
        m.LRUdlaMS();
    }
}