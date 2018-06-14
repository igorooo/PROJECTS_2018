import java.util.Comparator;

public class Osoba {

    String imie,nazwisko;
    int wiek;

    public Osoba(String imie,String nazwisko, int wiek){
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wiek = wiek;
    }


    public static final Comparator<Osoba> comp = new Comparator<Osoba>() {
        @Override
        public int compare(Osoba o1, Osoba o2) {
            return o1.nazwisko.compareTo(o2.nazwisko);
        }
    };

    public static final Comparator<Osoba> comp2 = new Comparator<Osoba>() {
        @Override
        public int compare(Osoba o1, Osoba o2) {
            return  o1.imie.compareTo(o2.imie);
        }
    };

    public static final Comparator<Osoba> comp3 = new Comparator<Osoba>() {
        @Override
        public int compare(Osoba o1, Osoba o2) {
            return o1.wiek - o2.wiek;
        }
    };



    @Override
    public String toString() {
        return (nazwisko+" "+imie+" "+Integer.toString(wiek));
    }


}
