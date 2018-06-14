/**
 * Created by PC on 26.02.2018.
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;



public class test {






    public static Student[] convert(ArrayList<String> list) throws IndexOutOfBoundsException{

        Iterator<String> iter = list.iterator();



        int len = list.size(), i=0;
        double grade=0;

        Student[] studs = new Student[len];

        String id=null,name=null,surname=null,title,arg;

        String[] SPLIT;

        if(iter.hasNext())
            Student.title = iter.next();

        while(iter.hasNext()){

            arg = iter.next();

            arg.trim();

            SPLIT = arg.split("\\s+");

            try{
                id = SPLIT[0];
                name = SPLIT[1];
                surname = SPLIT[2];
                grade = Double.parseDouble(SPLIT[3]);


            }

            catch (IndexOutOfBoundsException e){

                System.out.println("Wrong input");
                System.exit(0);
            }


            studs[i] = new Student(id,name,surname,grade);
            i++;
        }

        return studs;

    }

    public static void showup(Student[] studs,int len){

        int i=8;



        ITab iter = new ITab(studs,len);


        iter.first();

        while(!iter.isDone()){
            iter.current().PRINT();
            iter.next();

        }


    }

    public static void edit_grade(Student[] studs, String id, int len,double grade){

        Student var;
        int i;

        Iter<Student> iter = new Iter<Student>(studs);

        Predicate<Student> pred = new Predicate<Student>() {
            @Override
            public boolean accept(Student arg) {
                if(arg.id.compareTo(id) == 0)
                    return true;

                return false;
            }
        };

        Filtrit<Student> filtr = new Filtrit<Student>(iter,pred);

        filtr.next().grade  = grade;


    }

    public static void avarage_grades(Student[] studs, int len){

        double sum=0,amount=0, result;
        int i=0;

        Iter<Student> iter = new Iter<Student>(studs);

        Predicate<Student> pred = new Predicate<Student>() {
            @Override
            public boolean accept(Student arg) {
                return arg.grade >= 3.0;
            }
        };

        Filtrit<Student> filtr = new Filtrit<Student>(iter,pred);

        while(filtr.hasNext()){
            sum += filtr.next().grade;
            amount += 1;
        }


        if(amount == 0){
            System.out.println("There is no positive grades");
        }

        else{
            result = sum / amount;
            System.out.print("Avarage positive grades: ");
            System.out.println(result);
        }
    }

    public static void showup_bad_students(Student[] studs, int len){

        Iter<Student> iter = new Iter<Student>(studs);

        Predicate<Student> pred = new Predicate<Student>() {
            @Override
            public boolean accept(Student arg) {
                return arg.grade < 3.0;
            }
        };

        Filtrit<Student> filtr = new Filtrit<Student>(iter,pred);

        System.out.println("Students with < 3 grades:");

        while(filtr.hasNext())
            filtr.next().PRINT();

    }


    public static ArrayList<String> loadToArray() throws IOException {

        String line;
        FileReader fr = new FileReader("tt.txt");
        BufferedReader in = new BufferedReader(fr);

        ArrayList<String> list = new ArrayList<String>();

        while((line = in.readLine()) != null)
            list.add(line);


        in.close();


        return list;


    }

    public static void save(Student[] studs, int len) throws FileNotFoundException{

        PrintWriter zapis = new PrintWriter("newtt.txt");

        int i;

        zapis.println(studs[0].title);

        for(i=0 ; i < len ; i++){
            studs[i].SAVE(zapis);
        }

        zapis.close();
    }




    public static void main(String[] args) throws IOException {

        ArrayList<String> list = loadToArray();
        Student[] studs = convert(list);

        int len = list.size()-1;

        showup(studs, len);

        edit_grade(studs,"123",len,6);

        showup(studs, len);

        avarage_grades(studs,len);

        showup_bad_students(studs,len);

        save(studs, len);

    }
}
