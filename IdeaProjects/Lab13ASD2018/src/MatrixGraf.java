import com.sun.jmx.remote.internal.ArrayQueue;

import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MatrixGraf {

    boolean[][] matrix;

    String[] NodeNames;

    int currentsize, maxsize;


    public MatrixGraf(int maxsize){

        this.currentsize = 0;
        this.maxsize = maxsize;

        matrix = new boolean[maxsize][maxsize];
        NodeNames = new String[maxsize];



        for(int i = 0; i < maxsize; i++){
            NodeNames[i] = null;

            for(int j = 0; j < maxsize; j++){
                matrix[i][j] = false;

                if( j == i){
                    matrix[i][j] = true;
                }
            }
        }
    }

    public void addNode(String node){

        NodeNames[currentsize++] = node;
    }

    public void addPath(String nodeA, String nodeB){

        int A = -1,B = -1;

        for(int i = 0; i < currentsize; i++){

            if(NodeNames[i].compareTo(nodeA) == 0){
                A = i;
            }
            if(NodeNames[i].compareTo(nodeB) == 0){
                B = i;
            }
        }

        if(A == -1 || B == -1){

            System.out.println("There is no such a node");
            return;
        }

        matrix[A][B] = true;
        matrix[B][A] = true;
    }

    public String NN(int i){
        return NodeNames[i];
    }

    public void display(){

        System.out.println("\n\n  ");

        for(int i = 0; i < currentsize; i++){

            System.out.print("  "+NodeNames[i]);
        }

        for(int i = 0; i < currentsize; i++){

            System.out.print("\n"+NodeNames[i]);

            for(int j = 0; j < currentsize; j++){

                if(matrix[i][j] == true){
                    System.out.print(" 1 ");
                }

                else{
                    System.out.print(" 0 ");
                }
            }
          //  System.out.print("\n");
        }

        System.out.print("\n\n");

    }



    public void BFS(){

        Queue<Integer> queue = new LinkedList<Integer>();
        boolean[] visited = new boolean[maxsize];

        for(int k = 0; k < maxsize; k++){
            visited[k] = false;
        }

        int v,u;
        visited[0] = true;

        queue.add(0);

        while( !queue.isEmpty() ){

            v = queue.poll();
            System.out.print( NN(v) + "\n --> ");

            for(int j = 0; j < currentsize; j++){

                if(matrix[v][j] == false  ||  visited[j] == true){
                    continue;
                }
                System.out.print( NN(j) + ", " );
                queue.add(j);
                visited[j] = true;
            }
            System.out.println();

        }

    }

    boolean[] visited = new boolean[maxsize];

    public void DFS(){

        visited = new boolean[maxsize];

        for(int k = 0; k < maxsize; k++){
            visited[k] = false;
        }

        DFS_(0);

    }



    public void DFS_(int v){

        visited[v] = true;



        System.out.print( NN(v) + "\n --> ");

        for(int j = 0; j < currentsize; j++){

            if( matrix[v][j]  &&  !visited[j] ){
                DFS_(j);
            }

        }

    }




}
