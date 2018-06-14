import java.util.Comparator;

public class InsertSort<E> {


    public E[] sort(E[] args, Comparator<E> comp){

        E act,temp;
        int i,j;

        for(i = 0; i < args.length; i++){

            act = args[i];

            j=i-1;

            while( (j >= 0)   &&   (comp.compare(act ,  args[j]) < 0)){

                args[j+1] = args[j];
                j--;
            }

            args[j+1] = act;

        }

        return args;
    }


}
