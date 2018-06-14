import java.util.Comparator;

public class SelectSort<E> {



    public E[] sort(E[] args,Comparator<E> comp){

        E act,temp;
        int i,j=args.length-1,min;

        for(i = 0; i < args.length-1; i++) {

            min = i;

            for (j = i + 1; j < args.length; j++) {
                if (comp.compare(args[i], args[j]) > 0) {
                    min = j;
                }
            }

            temp = args[i];
            args[i] = args[min];
            args[min] = temp;
        }

        return args;
    }

}
