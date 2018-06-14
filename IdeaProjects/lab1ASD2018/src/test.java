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

        int i;


        studs[0].TITLE();

        for(i = 0; i < len ; i++){
            studs[i].PRINT();
        }

    }

    public static void edit_grade(Student[] studs, String id, int len,double grade){

        int i;

        for(i=0; i < len; i++){

            //System.out.println(studs[i].id);

            if(studs[i].id.compareTo(id) == 0){

                studs[i].grade = grade;

                return ;
            }
        }

        System.out.println("Can't find indicated id");

    }

    public static void avarage_grades(Student[] studs, int len){

        double sum=0 ,amount=0, result;
        int i;

        for(i=0 ; i < len ; i++){

            if(studs[i].grade >= 3.0){
                sum += studs[i].grade;
                amount += 1;
            }
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

        int i;

        System.out.println("Students with < 3 grades:");

        for(i=0 ; i < len ; i++){

            if(studs[i].grade < 3.0){

                studs[i].PRINT();
            }
        }

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
