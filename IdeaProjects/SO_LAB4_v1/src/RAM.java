import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RAM {

    ArrayList<Page> frames;
    int AMOUNT_OF_FRAMES;

    public RAM(int AMOUNT_OF_FRAMES){

        this.frames = new ArrayList<Page>();
        this.AMOUNT_OF_FRAMES = AMOUNT_OF_FRAMES;


    }

    public void setFrames(int AMOUNT_OF_FRAMES) {
        this.AMOUNT_OF_FRAMES = AMOUNT_OF_FRAMES;
        restart();
    }


    public void decreaseAOF(){  //decrease AMOUNT OF FRAMES

        if( isFull() ){

            Page page = new Page(-1);
            Stat st = new Stat();
            LRU(page,st);
            frames.remove(page);
            AMOUNT_OF_FRAMES--;


        }

        else {
            AMOUNT_OF_FRAMES--;
        }

    }

    public void increaseAOF(){  //increase AMOUNT OF FRAMES
        AMOUNT_OF_FRAMES ++;
    }



    public void restart(){
        frames = new ArrayList<Page>();
    }


    public boolean contains(Page page){

        return frames.contains(page);

    }

    public boolean isFull(){
        return !(frames.size() < AMOUNT_OF_FRAMES);
    }



    public void LRU(Page page ,Stat st){

        if( contains(page) ){
            frames.remove(page);
            frames.add(page);
            return;
        }


        else{

            if( isFull()){

                frames.remove(0);
                frames.add(page);
                page.changeBit();
            }

            else{
                frames.add(page);
                page.changeBit();
            }

            st.up();

        }


    }

    public void print(){
        for(int i = 0; i < frames.size(); i++){
            System.out.print(frames.get(i).id + " ");
        }
        System.out.println();
    }



}
