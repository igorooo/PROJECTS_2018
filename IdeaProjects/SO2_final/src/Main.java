

public class Main {

    /** PARAMETRY PROGRAMU */

    public static final int MAX_BLOCKS = 100;
    public static final int MAX_DEADLINE = 20;
    public static final int MAX_UNITS = 100;
    public static final int CHANCE_FOR_REALTIME_APPEARANCE = 100; // 10 = 1/10 CHANCE, 100 = 1/100



    public static void main(String []args) throws InterruptedException{

        Disc disc = new Disc();

        System.out.println("FCFS : " + disc.FCFS());
        System.out.println("SSTF : " + disc.SSTF());
        System.out.println("SCAN : " + disc.SCAN());
        System.out.println("C-SCAN : " + disc.CSCAN());

    }

}
