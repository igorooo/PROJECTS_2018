public class test {
    public static void main(String[] args){
        LinkStack<Integer> stos = new LinkStack<Integer>();

        stos.push(1);
        stos.push(2);
        stos.push(3);
        stos.push(4);
        stos.push(5);
        stos.push(6);



        System.out.println(stos.pop());
        System.out.println(stos.pop());

        System.out.println("-------------");

        LinkQueue<Integer> kolejka = new LinkQueue<Integer>();

        kolejka.enqueue(1);
        kolejka.enqueue(2);
        kolejka.enqueue(3);
        kolejka.enqueue(4);
        kolejka.enqueue(5);
        kolejka.enqueue(6);

        System.out.println(kolejka.dequeue());
        System.out.println(kolejka.dequeue());
        System.out.println(kolejka.dequeue());

    }
}
