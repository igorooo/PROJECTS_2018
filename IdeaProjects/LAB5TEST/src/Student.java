public class Student {

    int index;
    String nazwisko;

    public Student(int index, String nazwisko){
        this.index = index;
        this.nazwisko = nazwisko;
    }

    @Override
    public String toString() {
        return "Index: " + index + " Nazwisko: " + nazwisko;
    }
}
