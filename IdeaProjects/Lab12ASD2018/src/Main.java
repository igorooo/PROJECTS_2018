public class Main {


    public static void main(String[] args){


        SetsOnTable set = new SetsOnTable(100);

        set.Make_Set(5);
        set.Make_Set(25);

        set.add_to_Set(5,6);
        set.add_to_Set(5,7);
        set.add_to_Set(5,8);
        set.add_to_Set(5,9);
        set.add_to_Set(5,10);
        set.add_to_Set(25,26);
        set.add_to_Set(25,27);
        set.add_to_Set(27,28);
        set.add_to_Set(28,29);



        set.display();
        set.Union(26,5);
        set.display();

        SetsOnTable sett = new SetsOnTable(100);

        for(int i = 0; i < 10; i ++){

            sett.add_to_Set();

        }


        //---------------

        SetOnList<String> set1 = new SetOnList<>();

        set1.Make_Set("set1");

        set1.Make_Set("set2");

        set1.add_to_Set("set1","1e");
        set1.add_to_Set("set1","1f");
        set1.add_to_Set("set1","1g");
        set1.add_to_Set("set1","1h");
        set1.add_to_Set("set2","2e");
        set1.add_to_Set("set2","2f");
        set1.add_to_Set("2e","2g");

        set1.display();

        System.out.println(set1.findSet("set1").high + "   " + set1.findSet("set2").high);

        set1.Union("2e","set1");

        set1.display();

        System.out.println(set1.findSet("set1").high + "   " + set1.findSet("set2").high);

    }




}
