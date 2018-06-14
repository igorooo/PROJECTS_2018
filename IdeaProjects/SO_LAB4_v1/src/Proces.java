import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Proces {

    ArrayList<Page> calls;
    ArrayList<Page> pages;
    ArrayList<Page> called;
    int id,callslimit;
    int lower, upper; //borders
    Stat st;
    int priority;
    int AMOUNT_OF_PAGES;
    int WORKING_SET_SIZE;
    int WS_COUNT;

    Iterator<Page> iter;

    int PAGE_FAULT;

    public Proces(int id,int AMOUNT_OF_PAGES, int lower, int upper, ArrayList<Page> pages){

        Random rand = new Random();

        this.id = id;
        this.callslimit = rand.nextInt(20*AMOUNT_OF_PAGES)+2;
        this.lower = lower;
        this.upper = upper;

        this.called = new ArrayList<Page>();
        this.WORKING_SET_SIZE = ( AMOUNT_OF_PAGES / 2) +1;
        this.WS_COUNT = 0;

        this.PAGE_FAULT = 0;
        st = new Stat();

        this.AMOUNT_OF_PAGES = AMOUNT_OF_PAGES;
        this.pages = pages;

        calls = calls_gen(callslimit);
        iter = calls.iterator();


/*
        System.out.println("Proces: "+id + " am. of pages: "+ AMOUNT_OF_PAGES + "  lower bound: "+lower + "  upper bound: "+ upper +  "  calls: ");
        for(Page page: calls){
            System.out.print(page+", ");

        }
        System.out.println(); */
    }

    public ArrayList<Page> calls_gen(int callslimit){

        Random rand = new Random();
        ArrayList<Page> calls = new ArrayList<>(callslimit);
        Page page;

        int nextcall;

        for(int i = 0; i < callslimit; i++){


            nextcall = rand.nextInt(upper-lower);
            nextcall += lower;
            page = pages.get(nextcall);  //getting next page from page list
            calls.add(page);
        }


        return calls;
    }

    public void setPriority(int priority){
        this.priority = priority;
    }

    public boolean hasNext(){
        return iter.hasNext();
    }

    public Page next(){

        if(iter.hasNext()){

            Page p = iter.next();

            if( (WS_COUNT < WORKING_SET_SIZE)  &&  (!called.contains(p)) ){

                called.add(p);
                WS_COUNT ++;
                return p;
            }
            return p;
        }
        return null;
    }

    public void nextPF(){
        PAGE_FAULT ++;
    }

    public int showPF(){
        return PAGE_FAULT;
    }

    public void reset(){
        iter = calls.iterator();
        called.clear();
        WS_COUNT = 0;
        PAGE_FAULT = 0;
    }












}
