import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class SJF {
	public SJF() {
	}

	public double doIt(Rekord[] records) {
		int time = 0, iterTablicy = 0;
		int lacznyCzasOczekiwania = 0;
		ArrayList<Rekord> kolejka = new ArrayList<Rekord>();
		while (iterTablicy < records.length || !kolejka.isEmpty()) {
			// dodawanie watkow do tablicy jesli sie pojawily
			while (iterTablicy < records.length
					&& records[iterTablicy].czasZgloszenia == time) {
				kolejka.add(records[iterTablicy]);
				iterTablicy++;
			}
			if (!kolejka.isEmpty()) {
				// pobranie pierwszego elementu z kolejki do wykonania
				Rekord actual = kolejka.remove(0);
				// wykonanie jednostki czasu na procesie
				actual.dlugosc--;
				// dodawanie oczekiwania dla wszystkich czekajacych procesow w
				// kolejce
				Iterator<Rekord> it = kolejka.iterator();
				while (it.hasNext())
					it.next().czasOczekiwania++;
				// sortujemy pozostale elementy po dlugosci zadania
				Collections.sort(kolejka);
				// jesli skonczono proces to go wyrzucamy i czytamy staty, jesli
				// nie to wraca do kolejki
				if (actual.dlugosc <= 0)
					lacznyCzasOczekiwania += actual.czasOczekiwania;
				else
					kolejka.add(0, actual);
			}
			time++;
		}
		return lacznyCzasOczekiwania * 1.0 / records.length;
	}
}
