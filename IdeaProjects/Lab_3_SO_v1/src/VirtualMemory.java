import java.util.ArrayList;

public class VirtualMemory {

    int APROKS = 100;

    ArrayList<Page> pages;
    int AMOUNT_OF_PAGES;
    int AMOUNT_OF_FRAMES;
    int tab[];
    Time time;
    RAM ram;
    Stat fifo = new Stat();
    Stat lru = new Stat();
    Stat alru = new Stat();
    Stat random = new Stat();
    Stat opt = new Stat();

    public VirtualMemory(int AMOUNT_OF_PAGES,int AMOUNT_OF_FRAMES, int tab[], Time time){

        this.tab = tab;
        this.time = time;


        this.pages = new ArrayList<Page>(AMOUNT_OF_PAGES);
        this.AMOUNT_OF_PAGES = AMOUNT_OF_PAGES;
        this.AMOUNT_OF_FRAMES = AMOUNT_OF_FRAMES;

        for(int i = 0; i < AMOUNT_OF_PAGES ; i++){
            pages.add(new Page(i));
        }

        ram = new RAM(AMOUNT_OF_FRAMES,time);


        OPT();
        FIFO();
        LRU();
        ALRU();
        RAND();


    }

    public void FIFO(){

        int array[] = tab;
        ram.restart();
        fifo.restart();

        Page page;

        for(int i = 0; i < array.length; i++){

            page = pages.get( array[i] );
            ram.FIFO(page,fifo);

        }

       //System.out.println(fifo.);

        System.out.print("FIFO: ");
        fifo.show();



    }


    public void LRU(){

        int array[] = tab;
        ram.restart();
        lru.restart();

        Page page;

        for(int i = 0; i < array.length; i++){

            page = pages.get( array[i] );
            ram.LRU(page,lru);

        }

        //System.out.println(fifo.);
        System.out.print("LRU: ");
        lru.show();



    }

    public void ALRU(){

        int array[] = tab;
        ram.restart();
        alru.restart();

        Page page;

        for(int i = 0; i < array.length; i++){

            page = pages.get( array[i] );
            ram.ALRU(page,APROKS,alru);

        }

        //System.out.println(fifo.);
        System.out.print("ALRU: ");
        alru.show();



    }


    public void RAND(){

        int array[] = tab;
        ram.restart();
        random.restart();

        Page page;

        for(int i = 0; i < array.length; i++){

            page = pages.get( array[i] );
            ram.RAND(page,random);

        }

        //System.out.println(fifo.);
        System.out.print("RAND: ");
        random.show();



    }


    public void OPT(){

        int array[] = tab;
        ram.restart();
        opt.restart();


        Page page;

        for(int i = 0; i < array.length; i++){

            page = pages.get( array[i] );

            int temp[] = new int[array.length - i +5];
            int l = 0;

           System.out.println("-------");

            for(int j = i+1; j < array.length; j++){          //temp - tablica kolejnych zapytan po zapytaniu numer i
                temp[l] = array[j];
                System.out.print(temp[l] + " ");
                l++;

            }

            ram.OPT(page,opt,temp);

        }
        System.out.print("OPT: ");
        opt.show();

    }



    public void show(){

        for(int i = 0; i < tab.length ; i++){
            System.out.print(tab[i] + " ");
        }

    }


}
