import java.util.*;

public class Zgloszenie {
	private final int MAX_BLOK = 500;
	private int blok;
	boolean zrobiony;
	
	public Zgloszenie(){
		Random rand = new Random();
		blok = rand.nextInt(MAX_BLOK+1);
		zrobiony = false;
	}
	
	public int getBlok(){
		return blok;
	}
}
