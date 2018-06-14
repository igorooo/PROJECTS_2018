import java.util.ArrayList;

public class WorkingSet {

    ArrayList<ArrayList<Page>> array = new ArrayList<>();
    ArrayList<Integer> ignored;
    ArrayList<Proces> process;
    ArrayList<RAM> ram;
    int AMOUNT_OF_FRAMES;



    public WorkingSet(ArrayList<Stat> st, ArrayList<Proces> process, ArrayList<RAM> ram, int AMOUNT_OF_FRAMES, ArrayList<Integer> ignored){

        int l;
        this.ignored = ignored;
        this.AMOUNT_OF_FRAMES = AMOUNT_OF_FRAMES;
        this.process = process;
        this.ram = ram;

        for(int i = 0; i < 10; i++){

            array.add( process.get(i).called );


        }
     /*   for(ArrayList<Page> p:array){
            System.out.println(" ..:::SizeOfCalled: "+p.size());
        } */
    }

    public Integer max(){

        int max = 0, index = 0, ind = 0;

        for(ArrayList<Page> var: array ){

            if( !ignored.contains(index) ){

                if(var.size() > max){
                    max = var.size();
                    ind = index;
                }
            }

            index ++;
        }
        return new Integer(ind);
    }

    public Integer min(){

        Integer min = new Integer(100000);

        for(Integer var: ignored ){


            if(var < min){
                min = var;
            }
        }
        return min;
    }


    public void addIgnore(){


        while( CountTotal() >= AMOUNT_OF_FRAMES  && ignored.size() <= 10){

            Integer i = max();

            ignored.add(i);
            System.out.println("......::::::Addind ignore for: " + i);
        }

    }

    public void removeIgnore(){


        while( CountTotal() < AMOUNT_OF_FRAMES && ignored.size() > 0){

            Integer i = min();

            if( (CountTotal() + array.get(i).size()) < AMOUNT_OF_FRAMES){

                ignored.remove(i);
                System.out.println("......::::::Removing ignore for: " + i);
            }

            else{
                return;
            }
        }
    }

    public void setFrames(){

        int total = 0;
        int index = 0;

        for(int i = 0; i < 10; i++){

            if( array.get(i).size() > AMOUNT_OF_FRAMES){

                ram.get(i).setFrames(AMOUNT_OF_FRAMES);
            }

            else{
                ram.get(i).setFrames( array.get(i).size() +1 );
            }
        }
    }


    public int CountTotal(){

        int total = 0;
        int index = 0;

        for(ArrayList<Page> page: array){

            if( !ignored.contains(index) ){

                total += page.size();
            }

            index++;
        }

        return total;
    }

    public void display(){

        for( Integer i: ignored){
            System.out.println("Ignored: "+ i);
        }

    }





}
