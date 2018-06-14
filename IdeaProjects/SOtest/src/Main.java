import java.util.Random;

public class Main {
	static int iloscCiagowTestowych = 1000;
	static int iloscWatkowWCiagu = 20;
	static int minDlugoscWatku = 10;
	static int maxDlugoscWatku = 20;
	static int maxOpoznienieWatku = 10;
	static int kwantCzasu = 5;

	public static void main(String[] args) {
		double czasFCFS = 0,czasSJF = 0,czasSJFw = 0,czasRR = 0;
		for (int i = 0; i < iloscCiagowTestowych; i++) {
			Rekord[] tab = generujCiag();
			FCFS fcfs = new FCFS();
			czasFCFS+= fcfs.doIt(kopiujTablice(tab));
			SJF sjf = new SJF();
			czasSJF+= sjf.doIt(kopiujTablice(tab));
			SJFw sjfw = new SJFw();
			czasSJFw+= sjfw.doIt(kopiujTablice(tab));
			RR rr = new RR(kwantCzasu);
			czasRR+= rr.doIt(kopiujTablice(tab));
			
		}
		System.out.println(czasFCFS/iloscCiagowTestowych);
		System.out.println(czasSJF/iloscCiagowTestowych);
		System.out.println(czasSJFw/iloscCiagowTestowych);
		System.out.println(czasRR/iloscCiagowTestowych);
		
	}

	private static Rekord[] generujCiag() {
		Rekord[] tab = new Rekord[iloscWatkowWCiagu];
		Random r = new Random();
		tab[0] = new Rekord(r.nextLong(), r.nextInt(maxDlugoscWatku
				- minDlugoscWatku)
				+ minDlugoscWatku, r.nextInt(maxOpoznienieWatku));
		for (int i = 1; i < tab.length; i++) {
			tab[i] = new Rekord(r.nextLong(), r.nextInt(maxDlugoscWatku
					- minDlugoscWatku)
					+ minDlugoscWatku, tab[i - 1].czasZgloszenia
					+ r.nextInt(maxOpoznienieWatku));
		}
		return tab;
	}

	private static Rekord[] kopiujTablice(Rekord[] tab) {
		Rekord[] wyn = new Rekord[tab.length];
		for (int i = 0; i < wyn.length; i++) {
			wyn[i] = tab[i].clone();
		}
		return wyn;
	}
}
