import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class VirtualMemory {


    ArrayList<Page> pages;
    ArrayList<Proces> process;
    int AMOUNT_OF_PAGES;
    int AMOUNT_OF_FRAMES;
    Stat lru = new Stat();
    Random rand = new Random();
    JTextArea field;

    public VirtualMemory(int AMOUNT_OF_PAGES,int AMOUNT_OF_FRAMES){





        this.pages = new ArrayList<Page>(AMOUNT_OF_PAGES);
        this.AMOUNT_OF_PAGES = AMOUNT_OF_PAGES;
        this.AMOUNT_OF_FRAMES = AMOUNT_OF_FRAMES;

        for(int i = 0; i < AMOUNT_OF_PAGES ; i++){
            pages.add(new Page(i));
        }

        GEN gen = new GEN(pages,AMOUNT_OF_PAGES);

        process = gen.generate();

        PROPORTIONAL_ALLOCATION(process);
        CONSTANT_ALLOCATION(process);
        DYNAMIC_ALLOCATION(process);
        WORKING_SET(process);




    }

    public VirtualMemory(int AMOUNT_OF_PAGES, int AMOUNT_OF_FRAMES, JTextArea field){


        this.pages = new ArrayList<Page>(AMOUNT_OF_PAGES);
        this.AMOUNT_OF_PAGES = AMOUNT_OF_PAGES;
        this.AMOUNT_OF_FRAMES = AMOUNT_OF_FRAMES;
        this.field = field;
        this.field.setText("");

        for(int i = 0; i < AMOUNT_OF_PAGES ; i++){
            pages.add(new Page(i));
        }

        GEN gen = new GEN(pages,AMOUNT_OF_PAGES);

        process = gen.generate();

        PROPORTIONAL_ALLOCATION(process);
        CONSTANT_ALLOCATION(process);
        DYNAMIC_ALLOCATION(process);
        WORKING_SET(process);

    }

    public boolean isDone(ArrayList<Proces> process){

        for(Proces proc: process){
            if(proc.hasNext())
                return false;
        }

        return true;
    }


    public void PROPORTIONAL_ALLOCATION(ArrayList<Proces> process){

        int TOTAL_PAGES = 0, index = 0;
        ArrayList<Stat> st = new ArrayList<>();

        for(int i = 0; i < 10; i++){

            st.add(new Stat());
        }


        for(Proces proc: process){

            TOTAL_PAGES += proc.AMOUNT_OF_PAGES;
            proc.reset();
        }

        int FramesPerProc[] = new int[10];

        for(int i = 0; i < 10; i++){

            FramesPerProc[i] = (process.get(i).AMOUNT_OF_PAGES * AMOUNT_OF_FRAMES) / TOTAL_PAGES ;

            if(FramesPerProc[i] == 0){
                FramesPerProc[i] ++;
            }

          //  System.out.println("FRAME PER PROC: "+ FramesPerProc[i]);

        }

        ArrayList<RAM> ram = new ArrayList<>();

        for(int i = 0; i < 10; i++){

            RAM n = new RAM(FramesPerProc[i]);
            //System.out.println( "---->Ram nr. "+ i + "  size: "+ n.AMOUNT_OF_FRAMES);

            ram.add( n );

        }

        Proces current;

        while( !isDone(process) ){

            index = rand.nextInt(10);

            while( !process.get(index).hasNext() ){
                index = rand.nextInt(10);
            }

            current = process.get(index);


            ram.get(index).LRU(current.next(), st.get(index));

        }

        System.out.println("---------->PROPORTIONAL ALLOCATION <-------");

        int TOTAL_FOULTS = 0;

        for(int i = 0; i < 10; i++){

            System.out.println("Proces: "+process.get(i).id + "  Amount of Pages: "+ process.get(i).AMOUNT_OF_PAGES + "  Amount of calls: " + process.get(i).calls.size() + " Amount of page foults: "+ st.get(i).get());
            System.out.println("Avilable RAM frames: "+ ram.get(i).AMOUNT_OF_FRAMES);
            TOTAL_FOULTS += st.get(i).get();

        }

        System.out.println("Total page foults for all process: "+TOTAL_FOULTS);

        field.setText(field.getText() + "\n---------->PROPORTIONAL ALLOCATION <-------\n\n");


        for(int i = 0; i < 10; i++){

            field.setText(field.getText() + "Proces: "+process.get(i).id + "  Amount of Pages: "+ process.get(i).AMOUNT_OF_PAGES + "  Amount of calls: " + process.get(i).calls.size() + " Amount of page foults: "+ st.get(i).get() + "\n");
            field.setText(field.getText() + "Avilable RAM frames: "+ ram.get(i).AMOUNT_OF_FRAMES + "\n");

        }

        field.setText(field.getText() + "Total page foults for all process: "+TOTAL_FOULTS+"\n\n");

    }


    public void CONSTANT_ALLOCATION(ArrayList<Proces> process){

        int TOTAL_PAGES = 0, index = 0;
        ArrayList<Stat> st = new ArrayList<>();

        for(int i = 0; i < 10; i++){

            st.add(new Stat());
        }


        for(Proces proc: process){

            TOTAL_PAGES += proc.AMOUNT_OF_PAGES;
            proc.reset();
        }

        int FramesPerProc = AMOUNT_OF_FRAMES / 10;

        ArrayList<RAM> ram = new ArrayList<>();

        for(int i = 0; i < 10; i++){

            RAM n = new RAM(FramesPerProc);
            //System.out.println( "---->Ram nr. "+ i + "  size: "+ n.AMOUNT_OF_FRAMES);

            ram.add( n );

        }

        Proces current;

        while( !isDone(process) ){

            index = rand.nextInt(10);

            while( !process.get(index).hasNext() ){
                index = rand.nextInt(10);
            }

            current = process.get(index);


            ram.get(index).LRU(current.next(), st.get(index));

        }

        System.out.println("---------->CONSTANT ALLOCATION <-------");

        int TOTAL_FOULTS = 0;

        for(int i = 0; i < 10; i++){

            System.out.println("Proces: "+process.get(i).id + "  Amount of Pages: "+ process.get(i).AMOUNT_OF_PAGES + "  Amount of calls: " + process.get(i).calls.size() + " Amount of page foults: "+ st.get(i).get());
            System.out.println("Avilable RAM frames: "+ ram.get(i).AMOUNT_OF_FRAMES);
            TOTAL_FOULTS += st.get(i).get();

        }

        System.out.println("Total page foults for all process: "+TOTAL_FOULTS);

        field.setText(field.getText() + "---------->CONSTANT ALLOCATION <-------\n\n");


        for(int i = 0; i < 10; i++){

            field.setText(field.getText() + "Proces: "+process.get(i).id + "  Amount of Pages: "+ process.get(i).AMOUNT_OF_PAGES + "  Amount of calls: " + process.get(i).calls.size() + " Amount of page foults: "+ st.get(i).get() + "\n");
            field.setText(field.getText() + "Avilable RAM frames: "+ ram.get(i).AMOUNT_OF_FRAMES + "\n");

        }

        field.setText(field.getText() + "Total page foults for all process: "+TOTAL_FOULTS+"\n\n");

    }





    public void DYNAMIC_ALLOCATION(ArrayList<Proces> process){   // Setting frame amount by counting page foults for each process

        int TOTAL_PAGES = 0, index = 0, TOTAL_FRAMES = 0;
        ArrayList<Stat> st = new ArrayList<>();

        for(int i = 0; i < 10; i++){

            st.add(new Stat());
        }


        for(Proces proc: process){

            TOTAL_PAGES += proc.AMOUNT_OF_PAGES;
            proc.reset();
        }

        int FramesPerProc[] = new int[10];

        for(int i = 0; i < 10; i++){

            FramesPerProc[i] = (process.get(i).AMOUNT_OF_PAGES * AMOUNT_OF_FRAMES) / TOTAL_PAGES ;

            if(FramesPerProc[i] == 0){
                FramesPerProc[i] ++;
            }

            TOTAL_FRAMES += FramesPerProc[i];

            //  System.out.println("FRAME PER PROC: "+ FramesPerProc[i]);

        }

        ArrayList<RAM> ram = new ArrayList<>();

        for(int i = 0; i < 10; i++){

            RAM n = new RAM(FramesPerProc[i]);
            //System.out.println( "---->Ram nr. "+ i + "  size: "+ n.AMOUNT_OF_FRAMES);

            ram.add( n );

        }

        Proces current;

        WSK wsk = new WSK(st,process,ram,AMOUNT_OF_FRAMES);

        while( !isDone(process) ){

            index = rand.nextInt(10);

            while( !process.get(index).hasNext() ){
                index = rand.nextInt(10);
            }

            current = process.get(index);


            ram.get(index).LRU(current.next(), st.get(index));

            wsk.balance();

        }

        System.out.println("---------->DYNAMIC ALLOCATION<-------\n\n");

        int TOTAL_FOULTS = 0;

        for(int i = 0; i < 10; i++){

            System.out.println("Proces: "+process.get(i).id + "  Amount of Pages: "+ process.get(i).AMOUNT_OF_PAGES + "  Amount of calls: " + process.get(i).calls.size() + " Amount of page foults: "+ st.get(i).get());
            System.out.println("Avilable RAM frames: "+ ram.get(i).AMOUNT_OF_FRAMES);
            TOTAL_FOULTS += st.get(i).get();

        }

        System.out.println("Total page foults for all process: "+TOTAL_FOULTS);

        field.setText(field.getText() + "---------->DYNAMIC ALLOCATION<-------");


        for(int i = 0; i < 10; i++){

            field.setText(field.getText() + "Proces: "+process.get(i).id + "  Amount of Pages: "+ process.get(i).AMOUNT_OF_PAGES + "  Amount of calls: " + process.get(i).calls.size() + " Amount of page foults: "+ st.get(i).get() + "\n");
            field.setText(field.getText() + "Avilable RAM frames: "+ ram.get(i).AMOUNT_OF_FRAMES + "\n");

        }

        field.setText(field.getText() + "Total page foults for all process: "+TOTAL_FOULTS+"\n\n");

    }


    public void WORKING_SET(ArrayList<Proces> process){   // Setting frame amount by counting page foults for each process

        int TOTAL_PAGES = 0, index = 0, TOTAL_FRAMES = 0;
        ArrayList<Stat> st = new ArrayList<>();
        ArrayList<Integer> ignored = new ArrayList<>();

        for(int i = 0; i < 10; i++){

            st.add(new Stat());
        }


        for(Proces proc: process){

            TOTAL_PAGES += proc.AMOUNT_OF_PAGES;
            proc.reset();
        }


        ArrayList<RAM> ram = new ArrayList<>();

        for(int i = 0; i < 10; i++){

            RAM n = new RAM(AMOUNT_OF_FRAMES/10);
            //System.out.println( "---->Ram nr. "+ i + "  size: "+ n.AMOUNT_OF_FRAMES);

            ram.add( n );

        }

        WorkingSet ws = new WorkingSet(st,process,ram,AMOUNT_OF_FRAMES, ignored);

      //  ws.setFrames();

        System.out.println("WORKING SET TOTAL:  "+ ws.CountTotal());

        //ws.addIgnore();

      //  System.out.println("..");


      //  ws.display();



        Proces current;

        boolean flag = true;

        while(ignored.size() > 0 || flag ){
            flag = false;

            System.out.println(":::FIRST LOOP ::::WORKING SET TOTAL:  "+ ws.CountTotal());

            while( !isDone2(process,ignored) ){

                System.out.println(":::  IsDone2LOOP  "+ ws.CountTotal());

                index = rand.nextInt(10);

                while( ignored.contains(index)){
                    index = rand.nextInt(10);
                }

                System.out.println(" -->After1stWhile  "+ ws.CountTotal());


                while( !process.get(index).hasNext() ){
                    process.get(index).called.clear();
                    index = rand.nextInt(10);
                }

                System.out.println(" -->After2ndWhile  "+ ws.CountTotal());

                current = process.get(index);


                ram.get(index).LRU(current.next(), st.get(index));

                System.out.println(" -->After LRU  "+ ws.CountTotal());

                ws.removeIgnore();
                System.out.println(" -->After RemoveIgnore  "+ ws.CountTotal());
                ws.addIgnore();
                System.out.println(" -->After AddIgnore  "+ ws.CountTotal());


                ws.setFrames();
                System.out.println("2nd::::WORKING SET TOTAL:  "+ ws.CountTotal() + "   proces: "+current.id);

            }

            if( isDone2(process,ignored)){
                ws.removeIgnore();
                if( isDone2(process,ignored) ){
                    field.setText(" To small working set size in dependence of amount of frames ");
                    ignored.remove(ws.min());
                    //return;
                }

            }
        }



        System.out.println("---------->WORKING SET<-------");

        int TOTAL_FOULTS = 0;

        for(int i = 0; i < 10; i++){

            System.out.println("Proces: "+process.get(i).id + "  Amount of Pages: "+ process.get(i).AMOUNT_OF_PAGES + "  Amount of calls: " + process.get(i).calls.size() + " Amount of page foults: "+ st.get(i).get());
            System.out.println("Avilable RAM frames: "+ ram.get(i).AMOUNT_OF_FRAMES);
            TOTAL_FOULTS += st.get(i).get();

        }

        System.out.println("Total page foults for all process: "+TOTAL_FOULTS);

        field.setText(field.getText() + "---------->WORKING SET<-------\n\n");


        for(int i = 0; i < 10; i++){

            field.setText(field.getText() + "Proces: "+process.get(i).id + "  Amount of Pages: "+ process.get(i).AMOUNT_OF_PAGES + "  Amount of calls: " + process.get(i).calls.size() + " Amount of page foults: "+ st.get(i).get() + "\n");
            field.setText(field.getText() + "Avilable RAM frames: "+ ram.get(i).AMOUNT_OF_FRAMES + "\n");

        }

        field.setText(field.getText() + "Total page foults for all process: "+TOTAL_FOULTS+"\n\n");


    }



    public boolean isDone2(ArrayList<Proces> process, ArrayList<Integer> ignore){

        for(Proces proc: process){

            if( !ignore.contains(proc.id) ){
                if(proc.hasNext())
                    return false;
            }

        }

        return true;
    }





}
