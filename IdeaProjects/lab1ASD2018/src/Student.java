import java.io.PrintWriter;

/**
 * Created by PC on 27.02.2018.
 */
public class Student {

    public String id;
    public String name;
    public String surname;
    public double grade;
    public static String title;

    public Student(String id, String name, String surname, double grade){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.grade = grade;
    }

    public void PRINT(){
        System.out.print(id);
        System.out.print(" ");
        System.out.print(name);
        System.out.print(" ");
        System.out.print(surname);
        System.out.print(" ");
        System.out.println(grade);
    }

    public void SAVE(PrintWriter zapis){
        zapis.print(id);
        zapis.print(" ");
        zapis.print(name);
        zapis.print(" ");
        zapis.print(surname);
        zapis.print(" ");
        zapis.println(grade);
    }



    public static void TITLE(){
        System.out.println(title);
    }






}
