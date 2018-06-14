

public class Rekord implements Comparable<Rekord>{
	long numer;
	int dlugosc;
	int czasZgloszenia;
	int czasOczekiwania;
	public Rekord(long numer, int dlugosc, int czasZgloszenia
			) {
		super();
		this.numer = numer;
		this.dlugosc = dlugosc;
		this.czasZgloszenia = czasZgloszenia;
		czasOczekiwania = 0;
	}
	protected Rekord clone(){
		Rekord r = new Rekord(numer, dlugosc, czasZgloszenia);
		r.czasOczekiwania = czasOczekiwania;
		return r;
	}
	@Override
	public int compareTo(Rekord o) {
		return dlugosc<o.dlugosc?-1:dlugosc>o.dlugosc?1:0;
	}
}
