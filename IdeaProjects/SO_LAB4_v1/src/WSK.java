import java.util.ArrayList;

public class WSK {

    double tab[];
    ArrayList<RAM> ram;
    ArrayList<Proces> process;
    ArrayList<Stat> st;
    int AMOUNT_OF_FRAMES;

    public WSK(ArrayList<Stat> st, ArrayList<Proces> process, ArrayList<RAM> ram, int AMOUNT_OF_FRAMES){

        this.ram = ram;
        this.process = process;
        this.st = st;
        this.AMOUNT_OF_FRAMES = AMOUNT_OF_FRAMES;

        tab = new double[10];
    }

    public void setWsk(){

        for(int i = 0; i < 10; i++){

            //tab[i] = (st.get(i).get()*1.0) / (process.get(i).AMOUNT_OF_PAGES*1.0);
            tab[i] = (st.get(i).get()*1.0) / (ram.get(i).AMOUNT_OF_FRAMES * 1.0);
        }
    }

    public int TotalFoults(){

        int total = 0;

        for(Stat s: st){

            total += s.get();
        }

        return total;
    }


    public int max(){

        double m = 0;
        int index = 0;

        for(int i = 0; i < 10; i++){

            if( tab[i] > m ){

                m = tab[i];
                index = i;
            }
        }

        return index;
    }

    public int min(){

        double m = 10000;
        int index = 0;

        for(int i = 0; i < 10; i++){

            if( tab[i] < m ){

                if(ram.get(i).AMOUNT_OF_FRAMES > 2){
                    m = tab[i];
                    index = i;
                }
            }
        }

        return index;
    }


    public void balance(){

        setWsk();

        if( tab[max()] > tab[min()] *4   ){

            ram.get(max()).increaseAOF();
            ram.get(min()).decreaseAOF();
            //System.out.println("::::::::Increase: "+max() +" RAM frames: "+ram.get(max()).AMOUNT_OF_FRAMES  + " decrease: "+min() + " RAM frames: "+ ram.get(min()).AMOUNT_OF_FRAMES);

        }
    }





}
