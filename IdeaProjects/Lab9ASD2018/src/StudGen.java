import java.util.Random;

public class StudGen {

    HashMap array;
    int size;
    int amount;
    Random rand = new Random();


    public StudGen(HashMap array,double alfa){
        this.array = array;
        this.size = array.size();
        this.amount = (int)(alfa * (double)this.size);

        for(int i = 0; i < amount; i++){
            Student stud = new Student(Integer.toString(i),Integer.toString(rand.nextInt(10000)),Integer.toString(rand.nextInt(10000)),(double)rand.nextInt(6));
            array.put(stud.id,stud);
        }


    }









}
