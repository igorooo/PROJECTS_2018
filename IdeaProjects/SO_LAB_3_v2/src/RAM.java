import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RAM {

    ArrayList<Page> frames;
    ArrayList<Page> harray;
    int AMOUNT_OF_FRAMES;
    Time time;

    public RAM(int AMOUNT_OF_FRAMES, Time time){

        this.frames = new ArrayList<Page>(AMOUNT_OF_FRAMES+1);
        this.AMOUNT_OF_FRAMES = AMOUNT_OF_FRAMES;
        this.time = time;


    }

    public void setFrames(int AMOUNT_OF_FRAMES) {
        this.AMOUNT_OF_FRAMES = AMOUNT_OF_FRAMES;
        restart();
    }

    public void restart(){
        frames = new ArrayList<Page>(AMOUNT_OF_FRAMES+1);
    }

    public boolean addPage(Page page){

        if( !isFull() ){

            frames.add(page);
            page.changeBit();
            page.setTime(time.WhatTime());
            return true;
        }

        return false;

    }

    public boolean contains(Page page){

        return frames.contains(page);

    }

    public boolean isFull(){
        return !(frames.size() < AMOUNT_OF_FRAMES);
    }

    public void FIFO(Page page ,Stat st){

        if( contains(page) ){
            page.setTime(time.WhatTime());
            return;
        }

        else{

            if( isFull()){

                frames.get(0).changeBit();
                frames.remove(0);
                frames.add(page);
                page.changeBit();
                page.setTime(time.WhatTime());
            }

            else{
                frames.add(page);
                page.changeBit();
                page.setTime(time.WhatTime());
            }

            st.up();
            // add stats here    ,Stat st

        }

    }

    public void LRU(Page page ,Stat st){

        if( contains(page) ){
            page.setTime(time.WhatTime());
            frames.remove(page);
            frames.add(page);
            return;
        }


        else{

            if( isFull()){

                frames.get(0).changeBit();
                frames.remove(0);
                frames.add(page);
                page.changeBit();
                page.setTime(time.WhatTime());
            }

            else{
                frames.add(page);
                page.changeBit();
                page.setTime(time.WhatTime());
            }

            st.up();
            // add stats here

        }


    }

    public void ALRU(Page page, int apr ,Stat st){

        int APR = time.WhatTime() - apr;
        Random rand = new Random();

        if( contains(page) ){
            page.setTime(time.WhatTime());
            frames.remove(page);
            frames.add(page);
            return;
        }


        else{

            if( isFull()){

                int index = 0,l = 0;

                while(true){

                    int r = rand.nextInt(frames.size()-1);

                    if( frames.get(r).LAST_USE <= APR ){

                        index = r;
                        break;
                    }

                    if(l > frames.size()*2){
                        index = 0;
                        break;
                    }
                    l++;
                }

                frames.get(index).changeBit();
                frames.remove(index);
                frames.add(page);
                page.changeBit();
                page.setTime(time.WhatTime());

            }

            else{
                frames.add(page);
                page.setTime(time.WhatTime());
                page.changeBit();
            }

            st.up();
            // add stats here

        }

    }

    public void RAND(Page page ,Stat st){

        Random rand = new Random();

        if( contains(page) ){
            page.setTime(time.WhatTime());
            return;
        }

        else{

            if( isFull()){

                int index = rand.nextInt(frames.size()-1);

                frames.get(index).changeBit();
                frames.remove(index);
                frames.add(page);
                page.changeBit();
                page.setTime(time.WhatTime());
            }

            else{
                frames.add(page);
                page.changeBit();
                page.setTime(time.WhatTime());
            }

            st.up();
            // add stats here

        }

    }



    public void OPT(Page page ,Stat st, int tab[]){

        int index = 0;

        if( contains(page) ){
            page.setTime(time.WhatTime());
            return;
        }

        else{

            if( isFull()){

                int max;
                Page npage;
                int id;

                int var[] = new int[frames.size()];

                for(int i = 0; i < frames.size(); i++){  //setting initial values

                    var[i] = tab.length + 1;
                }


                for(int i = 0; i < frames.size(); i++){

                    id = frames.get(i).id;

                    for(int j = 0; j < tab.length; j++){

                        if( id == tab[j]){

                            if(j < var[i])

                                var[i] = j;

                        }
                    }
                }

                max = -1;
                int result = 0;


                for(int i = 0; i < var.length; i++){

                    if(var[i] == -1){
                        result = i;
                        break;
                    }

                    if( var[i] > max){
                        max = var[i];
                        result = i;
                    }

                }

                npage = frames.get(result);

                npage.changeBit();
                frames.remove(npage);
                frames.add(page);
                page.changeBit();
                page.setTime(time.WhatTime());


            }

            else{
                frames.add(page);
                page.changeBit();
                page.setTime(time.WhatTime());
            }

            st.up();

            // add stats here

        }

    }


    public void print(){
        for(int i = 0; i < frames.size(); i++){
            System.out.print(frames.get(i).id + " ");
        }
        System.out.println();
    }



}
