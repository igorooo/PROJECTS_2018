
public class Main {
	public static void main(String[] args){
		Osoba[] osoby = new Osoba[5];
		osoby[0] = new Osoba("Korzeniowski", "Rafał", 55);
		osoby[1] = new Osoba("Zawalny", "Michał", 20);
		osoby[2] = new Osoba("Korzeniowski", "Rafał", 35);
		osoby[3] = new Osoba("Zbiegniewski", "Andrzej", 12);
		osoby[4] = new Osoba("Zawalny", "Krzysztof", 39);

		InsertSort.sort(osoby, Osoba.PO_NAZWISKU);

		wyswietl(osoby);

		InsertSort.sort(osoby, Osoba.ZBIORCZY);

		wyswietl(osoby);

		osoby[0] = new Osoba("Korzeniowski", "Rafał", 55);
		osoby[1] = new Osoba("Zawalny", "Michał", 20);
		osoby[2] = new Osoba("Korzeniowski", "Rafał", 35);
		osoby[3] = new Osoba("Zbiegniewski", "Andrzej", 12);
		osoby[4] = new Osoba("Zawalny", "Krzysztof", 39);

		InsertSort.sort(osoby, new CompoundComparator<>(Osoba.PO_NAZWISKU, Osoba.PO_IMIENIU, Osoba.PO_WIEKU));

		wyswietl(osoby);

	}

	static void wyswietl(Osoba[] tab){
		for(int i = 0 ; i < tab.length; i++){
			System.out.println(tab[i]);
		}
		System.out.println();
	}

}
