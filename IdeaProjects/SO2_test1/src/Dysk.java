import java.util.*;

public class Dysk {
	public final int MAX_BLOKOW = 500;
	private final int LICZBA_ZGLOSZEN = 100;
	public List<Zgloszenie> queue = new ArrayList<Zgloszenie>();
	
	public Dysk(){
		for(int i=0; i < LICZBA_ZGLOSZEN; i++){
			queue.add(new Zgloszenie());
		}
	}
	
	public int FCFS(){
		int suma = 0;
		for(int i=0; i < queue.size()-1; i++){
			suma += mod(queue.get(i).getBlok(), queue.get(i+1).getBlok());
		}
		return suma;
	}
	
	public int SSTF(){
		int suma = 0;
		int current = 0;
		int currentMin = MAX_BLOKOW;
		int next = 0;
		int licznikZgloszen = 0;
		
		while(licznikZgloszen < LICZBA_ZGLOSZEN){
			for(int j=0; j < queue.size(); j++){
				if((mod(queue.get(current).getBlok(), queue.get(j).getBlok()) < currentMin) && (queue.get(j).zrobiony != true) && (current != j)){
					currentMin = mod(queue.get(current).getBlok(), queue.get(j).getBlok());
					next = j;
				}
			}
			suma += currentMin;
			queue.get(current).zrobiony = true;
			currentMin = MAX_BLOKOW;
			current = next;
			licznikZgloszen++;
		}
		zeruj();
		return suma;
	}
	
	public int CSCAN(){
		Random rand = new Random();
		int suma = 0;
		int blokTemp = 0;
		int addDiff = 0;
		int zrob;
		boolean brak = true;
		while(!kolejkaIsDone()){
			brak = true;
			for(int i=0; i <= MAX_BLOKOW; i++){
				for(int j=0; j < queue.size(); j++){
					int s = queue.get(j).getBlok();
					boolean jest = queue.get(j).zrobiony;
					zrob = rand.nextInt(2);
					if(s == i && !jest && zrob == 1){
						suma += mod(blokTemp, i) + addDiff;
						blokTemp = i;
						queue.get(j).zrobiony = true;
						addDiff = 0;
						brak = false;
					}
				}
			}
			if(brak == false){
				addDiff = MAX_BLOKOW - blokTemp;
			}
			else{
				addDiff += MAX_BLOKOW;
			}
			blokTemp = 0;
		}
		zeruj();
		return suma;
	}
	
	public int SCAN(){
		Random rand = new Random();
		int suma = 0;
		int blokTemp = 0;
		int zrob;
		while(!kolejkaIsDone()){
			for(int i=0; i <= MAX_BLOKOW; i++){
				for(int j=0; j < queue.size(); j++){
					int s = queue.get(j).getBlok();
					boolean jest = queue.get(j).zrobiony;
					zrob = rand.nextInt(2);
					if(s == i && !jest && zrob == 1){
						suma += mod(blokTemp, i);
						blokTemp = i;
						queue.get(j).zrobiony = true;
					}
				}
			}
			suma += mod(MAX_BLOKOW, blokTemp);
			for(int k=MAX_BLOKOW; k >= 0; k--){
				for(int l=0; l < queue.size(); l++){
					int s = queue.get(l).getBlok();
					boolean jest = queue.get(l).zrobiony;
					zrob = rand.nextInt(2);
					if(s == k && !jest && zrob == 1){
						suma += mod(blokTemp, k);
						blokTemp = k;
						queue.get(l).zrobiony = true;
					}
				}
			}
			if(!kolejkaIsDone()){
				suma += mod(0, blokTemp); 
			}
			blokTemp = 0;
		}
		zeruj();
		return suma;
	}
	
	public int mod(int l1, int l2){
		int suma = 0;
		if(l1 > l2){
			suma = l1-l2;
		}
		else{
			suma = l2-l1;
		}
		return suma;
	}

	public Zgloszenie NextShortestSeek(Zgloszenie current){

		int MIN_PATH = MAX_BLOKOW;
		Zgloszenie NEXT_BLOCK = current;

		for(int i = 0; i < queue.size(); i++){

			if((mod(current.getBlok(), queue.get(i).getBlok()) < MIN_PATH) && (!queue.get(i).zrobiony) && (current != queue.get(i))){
				MIN_PATH = mod(current.getBlok(), queue.get(i).getBlok());
				NEXT_BLOCK = queue.get(i);
			}

		}

		return NEXT_BLOCK;
	}
	
	public boolean kolejkaIsDone(){
		boolean isDone = true;
		for(int i=0; i < queue.size(); i++){
			if(queue.get(i).zrobiony == false){
				isDone = false;
				break;
			}
		}
		return isDone;
	}
	
	public void zeruj(){
		for(int i=0; i < queue.size(); i++){
			queue.get(i).zrobiony = false;
		}
	}
}


