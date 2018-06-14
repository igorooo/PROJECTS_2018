import java.util.Comparator;

public class Main {

    public static void main(String args[]){

        Osoba[] osoby = new Osoba[5];

        osoby[0] = new Osoba("aaa","JJJ",1);
        osoby[1] = new Osoba("ddd","GGG",2);
        osoby[2] = new Osoba("bbb","III",3);
        osoby[3] = new Osoba("eee","FFF",4);
        osoby[4] = new Osoba("ccc","HHH",5);

        CompoundComparator<Osoba> ccomps = new CompoundComparator<Osoba>();

        ccomps.addComparator(Osoba.comp);
        ccomps.addComparator(Osoba.comp2);
        ccomps.addComparator(Osoba.comp3);


        InsertSort<Osoba> Isort= new InsertSort<Osoba>();
        SelectSort<Osoba> Isort2= new SelectSort<Osoba>();


        osoby = Isort.sort(osoby,Osoba.comp);

        for(int i=0;i<osoby.length;i++){
            System.out.println(osoby[i]);
        }

        System.out.println("----");

        osoby = Isort2.sort(osoby,Osoba.comp2);

        for(int i=0;i<osoby.length;i++){
            System.out.println(osoby[i]);
        }

        System.out.println("----");

        osoby = Isort.sort(osoby,Osoba.comp3);

        for(int i=0;i<osoby.length;i++){
            System.out.println(osoby[i]);
        }

        System.out.println("----");


        osoby[0] = new Osoba("bbb","AAA",3);
        osoby[1] = new Osoba("bbb","AAA",2);
        osoby[2] = new Osoba("aaa","AAA",1);
        osoby[3] = new Osoba("ggg","BBB",4);
        osoby[4] = new Osoba("ggg","BBB",5);

        osoby = Isort.sort(osoby,ccomps);


        for(int i=0;i<osoby.length;i++){
            System.out.println(osoby[i]);
        }

        System.out.println("----");

    }
}
