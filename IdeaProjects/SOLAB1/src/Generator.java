import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class Generator {

    IQueue queue;

    int amount;

    private int MaxFazLength = 20;
    private int MaxDelay = 10;


    public Generator(IQueue queue){

        this.queue = queue;

    }

    public void setMaxFazLength(int MaxFazLength){
        this.MaxFazLength = MaxFazLength;
    }

    public void setMaxDelay(int MaxDelay){
        this.MaxDelay = MaxDelay;
    }



    public void generate(int amount) throws FileNotFoundException{

        PrintWriter save = new PrintWriter("test.txt");

        Proces arg;

        this.amount = amount;

        int i;

        Random rand = new Random();

        for( i=0; i < amount; i++){

            arg = new Proces(rand.nextInt(MaxFazLength),i+1, rand.nextInt(MaxDelay) );

            queue.addProces(arg);

            save.print("id: ");
            save.print(i+1);
            save.print("  ");
            save.print(arg.getFazaProc());
            save.print("  ");
            save.print(arg.getDelay());
            save.println("");

        }

        save.close();


    }
}
