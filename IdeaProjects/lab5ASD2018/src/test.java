


public class test {
    public static void main(String[] args){

        IOneWayLinkedList<Student> tab = new IOneWayLinkedList<Student>();





        tab.insert(0,new Student("0","qwe","asd",3));
        tab.insert(1,new Student("1","wer","wer",4));
        tab.insert(2,new Student("2","wer","wer",4));
        tab.insert(1,new Student("5","yui","yui",7));

        tab.wyswietlListe();

       // tab.get(1).PRINT();



    }
}
