import java.io.FileNotFoundException;

public class test {

    public static void main(String args[]) throws FileNotFoundException{

        IQueue queue = new IQueue();

        Generator gen = new Generator(queue);

        gen.generate(100);

        FCFS fcfs = new FCFS(queue);

        Rot rot = new Rot(queue,25);

        SJF sjf = new SJF(queue);

        System.out.println(fcfs.getAvarageTime());
        System.out.println(rot.getAvarageTime());
        System.out.println(sjf.getAvarageTime());


    }
}
