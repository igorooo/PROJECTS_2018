import java.util.ArrayDeque;
import java.util.Iterator;

public class RR {
	private int kwantCzasu;

	public RR(int kwantCzasu) {
		this.kwantCzasu = kwantCzasu;
	}

	public double doIt(Rekord[] records) {
		int time = 0, iterTablicy = 0;
		int lacznyCzasOczekiwania = 0;
		int pozostaloKwantu = kwantCzasu;
		ArrayDeque<Rekord> kolejka = new ArrayDeque<Rekord>();
		while (iterTablicy < records.length || !kolejka.isEmpty()) {
			// dodawanie watkow do tablicy jesli sie pojawily
			while (iterTablicy < records.length
					&& records[iterTablicy].czasZgloszenia == time) {
				kolejka.add(records[iterTablicy]);
				iterTablicy++;
			}
			if (!kolejka.isEmpty()) {
				// pobranie pierwszego elementu z kolejki do wykonania
				Rekord actual = kolejka.poll();
				// wykonanie jednostki czasu na procesie
				actual.dlugosc--;
				pozostaloKwantu--;
				// dodawanie oczekiwania dla wszystkich czekajacych procesow w
				// kolejce
				Iterator<Rekord> it = kolejka.iterator();
				while (it.hasNext())
					it.next().czasOczekiwania++;
				// jesli skonczono proces to go wyrzucamy i czytamy staty, jesli
				// nie to wraca do kolejki
				if (actual.dlugosc <= 0) {
					lacznyCzasOczekiwania += actual.czasOczekiwania;
					pozostaloKwantu = kwantCzasu;
				} else {
					if (pozostaloKwantu > 0)
						kolejka.addFirst(actual);
					else {
						kolejka.add(actual);
						pozostaloKwantu = kwantCzasu;
					}
				}
			}
			time++;
		}
		return lacznyCzasOczekiwania * 1.0 / records.length;
	}
}
