
public class Main {
    public static void main(String[] args){
        LinkedList lista = new LinkedList();

        Student student1 = new Student(9999, "Trutututu");
        Student student2 = new Student(8888, "Jakiesnazwisko");

        lista.add(new Student(1234, "Kowalski"));
        lista.add(new Student(3224, "Nowak"));
        lista.add(student1);
        lista.add(new Student(5555, "Kadziel"));
        lista.add(student2);

        lista.insert(1,new Student(1111, "Rrrrrr"));

        lista.delete(student2);


        System.out.println("Index student1: " + lista.indexOf(student1));

        lista.wyswietlListe();

        lista.set(4, student2);
        System.out.println();
        Iterator it = lista.iterator();
        for(it.first(); !it.isDone(); it.next()){
            System.out.println(it.current());
        }
    }
}
