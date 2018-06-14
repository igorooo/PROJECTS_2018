public class Main {

    public static void main(String[] args){

        double ALFA = 0.2;



        HashMap studs = new HashMap(10000,true);

        StudGen gen = new StudGen(studs,ALFA);   //  if method == true then method is next Line adress

       // studs.dump();

        System.out.println("\n\n\n------------------- \n\n\n");

        HashMap studs1 = new HashMap(10000,false);

        StudGen gen1 = new StudGen(studs1,ALFA);   //  if method == true then method is next Line adress

        //studs1.dump();

        Comp comp = new Comp();

        System.out.println(studs.get("5000",comp));
        System.out.println(comp);

        System.out.println(studs1.get("5000",comp));
        System.out.println(comp);

    }
}
