import java.util.ArrayList;
import java.util.Random;

public class Generator {

    ArrayList<Proces> args;

    Proces arg;

    int i;

    public Generator(ArrayList<Proces> argz, int MAX_PHASE_LENGTH, int MAX_APPEAR_TIME,int AMOUNT){

        args = argz;

        Random rand = new Random();

        for(i = 0;i < AMOUNT; i ++){

            arg = new Proces(rand.nextInt(MAX_PHASE_LENGTH)+1, i , rand.nextInt(MAX_APPEAR_TIME)+1);

            args.add(arg);
        }

    }

}
