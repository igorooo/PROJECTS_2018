public class Main {

    public static void main(String[] args){

        MatrixGraf matrixGraf = new MatrixGraf(20);

        matrixGraf.addNode("A");
        matrixGraf.addNode("B");
        matrixGraf.addNode("C");
        matrixGraf.addNode("D");
        matrixGraf.addNode("E");

        matrixGraf.addPath("A","C");
        matrixGraf.addPath("B","E");
        matrixGraf.addPath("D","E");
        matrixGraf.addPath("A","E");
        matrixGraf.addPath("C","D");

        matrixGraf.display();
        System.out.println("-----------------BFS-------------");
        matrixGraf.BFS();

        System.out.println("-----------------DFS-------------");
        matrixGraf.DFS();
        System.out.println("-----------------END OF DFS-------------");

        ListGraf lg = new ListGraf();

        String a="A",b="B",c="C",d="D",e="E";

        lg.addNode(a);
        lg.addNode(b);
        lg.addNode(c);
        lg.addNode(d);
        lg.addNode(e);

        lg.addPath(a,c);
        lg.addPath(b,e);
        lg.addPath(d,e);
        lg.addPath(c,d);
        lg.addPath(a,e);
        lg.display();
        System.out.println("-----------------BFS-------------");
        lg.BFS();

        System.out.println("-----------------DFS-------------");
        lg.DFS();
        System.out.println("-----------------END OF DFS-------------");



    }
}
