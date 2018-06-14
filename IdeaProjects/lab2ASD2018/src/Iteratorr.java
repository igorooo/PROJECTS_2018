/**
 * Created by PC on 06.03.2018.
 */
public interface Iteratorr{
    void first();   // przejście na początek kolekcji
    void next();   //  przejście do przodu do kolejnego elementu
    boolean isDone();   // sprawdzenie, czy iterator wyszedł poza kolekcję
    Object current();   // odczytanie bieżącego elementu kolekcji
}
