import java.util.Random;

public class Generator {


    int LENGTH,RADIUS,AMOUNT_OF_PAGES;

    public Generator(){

        this.AMOUNT_OF_PAGES = 200;
        this.LENGTH = 10000;
        this.RADIUS = 15;


    }

    public void setLENGTH(int LENGTH){
        this.LENGTH = LENGTH;
    }

    public void setAMOUNT_OF_PAGES(int AMOUNT_OF_PAGES) {
        this.AMOUNT_OF_PAGES = AMOUNT_OF_PAGES;
    }

    public void setRADIUS(int RADIUS) {
        this.RADIUS = RADIUS;
    }

    public int[] gen(){

        int tab[] = new int[LENGTH];

        Random rand = new Random();
        int i = 0;

        while( i < LENGTH ){

            int x = rand.nextInt(AMOUNT_OF_PAGES-1);  // center of numbers

            int y = rand.nextInt(RADIUS) +1;    // radius

            for(int j = 0; j <= y; j++){



                int n = rand.nextInt(2*y);

                n += (x - y);  //offset vector = x-y

                while( n < 0 ){
                    n++;
                }

                while( n >= AMOUNT_OF_PAGES ){
                    n--;
                }

                tab[i] = n;
                i++;

                if(i >= LENGTH){
                    break;
                }
            }


        }

        return tab;
    }


}
