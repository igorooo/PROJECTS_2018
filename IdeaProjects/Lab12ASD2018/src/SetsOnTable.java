import java.util.ArrayList;

public class SetsOnTable {


    int[] array;


    public SetsOnTable(int size){

        array = new int[size];
        for(int i = 0; i < array.length; i++){
            array[i] = -100;
        }
    }

    public void resize(){

        int[] narray = new int[2*array.length];

        for(int i = 0; i < array.length; i++){

            narray[i] = array[i];
        }

        for(int i = array.length; i < narray.length; i++){
            narray[i] = -100;
        }

        array = narray;
    }


    public void Make_Set(int elem){

        array[elem] = elem;
    }

    public void add_to_Set(int Set,int Elem){

        array[Elem] = array[Set];
    }

    public void Union(int SetA, int SetB){

        int A = array[SetA], B = array[SetB];


        for(int i = 0; i < array.length; i++){

            if( array[i] == B){
                array[i] = A;
            }
        }
    }

    public int FindSet(int Elem){

        if(array[Elem] == Elem){
            return Elem;
        }

        return array[Elem];


    }

    public void displayy(){

        for(int i = 0; i < array.length; i++){

            if(array[i] != -100){
                System.out.print(i+" ->" +array[i]+ "   ");

            }

        }
        System.out.print("\n");
    }

    public void display(){

        ArrayList<Integer> tab = new ArrayList<>();

        for(int i = 0; i < array.length; i++){

            if( array[i] == i ){
                tab.add(i);
            }
        }

        for(Integer e:tab){

            System.out.print(e + ", ");
            for(int i = 0; i < array.length; i++){

                if(array[i] == e && i != array[i]){
                    System.out.print(i + ", ");
                }
            }
            System.out.println();
        }


    }

}
