import sun.awt.image.ImageWatched;

public class Main {

    public static void main(String[] args){

        BST bst = new BST();

        bst.addNode(5);
        bst.addNode(2);
        bst.addNode(7);
        bst.addNode(6);
        bst.addNode(1);
        bst.addNode(4);
        bst.addNode(3);
        bst.addNode(12);
        bst.addNode(9);
        bst.addNode(8);

        bst.inOrder();
        //bst.preOrder();

        bst.findNode(10);

        BST.Node x = bst.findNode(4);

        bst.findNode(5);
        bst.MIN();
        bst.MAX();
        bst.heigh();
        bst.InternalNodes();
        bst.ExternalNodes();
        bst.Leafs();

        bst.DisplayByLevels();

        System.out.println(bst.ElemBefore(x));
        System.out.println(bst.ElemNext(x));

        bst.DeleteNode(x);
        bst.DisplayByLevels();





    }

}
