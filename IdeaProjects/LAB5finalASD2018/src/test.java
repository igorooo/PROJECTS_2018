public class test {
    public static void main(String[] args){


        LinkedList<Student> list = new LinkedList<Student>();

        Student stud = new Student("7","seven","SEVEN",4);

        list.insert(0,new Student("1","first","FIRST",4));
        list.insert(1,new Student("2","sec","SEC",4));
        list.insert(2,new Student("3","third","THIRD",4));
        list.insert(2,new Student("4","four","FOUR",4));
        list.insert(4,new Student("5","five","FIVE",4));
        list.insert(2,new Student("6","six","SIX",4));
        list.insert(5,stud);

        list.wyswietlListe();

        System.out.println("---------");

        list.delete(stud);

        list.wyswietlListe();

        System.out.println("---------");

        list.delete(2);

        list.wyswietlListe();

        System.out.println("---------");

        System.out.println(list.contains(stud));

        list.set(0,stud);

        list.wyswietlListe();

        System.out.println("---------");

        System.out.println(list.get(0));

        System.out.println("-----ITERATOR----");

        list.PrintWithIter();

        list.clear();


    }
}
