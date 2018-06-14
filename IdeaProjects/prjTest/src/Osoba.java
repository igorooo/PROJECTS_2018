import java.util.Comparator;

public class Osoba {
	String nazwisko;
	String imie;
	int wiek;

	public  Osoba(String nazwisko, String imie, int wiek){
		this.nazwisko = nazwisko;
		this.imie = imie;
		this.wiek = wiek;
	}

	@Override
	public String toString() {
		return nazwisko + " " + imie + " " + wiek;
	}

	public static final Comparator<Osoba> PO_NAZWISKU = (o1, o2) -> o1.nazwisko.compareTo(o2.nazwisko);


	public static final Comparator<Osoba> PO_IMIENIU = (o1, o2) -> o1.imie.compareTo(o2.imie);

	public static final Comparator<Osoba> PO_WIEKU = (o1, o2) -> o1.wiek - o2.wiek;

	public static final Comparator<Osoba> ZBIORCZY = new Comparator<Osoba>() {
		@Override
		public int compare(Osoba o1, Osoba o2) {
			int c = PO_NAZWISKU.compare(o1, o2);

			if(c != 0){
				return c;
			}

			c = PO_IMIENIU.compare(o1, o2);

			if( c != 0){
				return c;
			}

			c = PO_WIEKU.compare(o1, o2);

			return c;
		}
	};
}
