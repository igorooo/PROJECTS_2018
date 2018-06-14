import java.util.Comparator;

public class InsertSort {

	public static void sort(Osoba[] tab, Comparator<Osoba> comparator){
		int j;
		for(int i=1; i<tab.length; i++ ){
			Osoba klucz = tab[i];
			j = i - 1;
			while( j >= 0 && comparator.compare(tab[j], klucz) >  0){
				tab[j+1] = tab[j];
				j = j -1;
			}
			tab[j+1] = klucz;
		}
	}
}
