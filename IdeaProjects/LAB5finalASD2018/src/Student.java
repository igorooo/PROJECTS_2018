import java.io.PrintWriter;


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

    public String toString() {
        return (id + " " + name + " " + surname + " " + Double.toString(grade));
    }


}
