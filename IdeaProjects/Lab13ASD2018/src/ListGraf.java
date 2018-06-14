import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

public class ListGraf {

    ArrayList<ArrayList<Integer>> array;
    ArrayList<String> NodeNames;



    public ListGraf(){

        array = new ArrayList<ArrayList<Integer>>();
        NodeNames = new ArrayList<>();
    }

    public void addNode(String node){

        NodeNames.add(node);
        array.add(new ArrayList<Integer>());

    }

    public void addPath(String nodeA, String nodeB){

        int A = NodeNames.indexOf(nodeA);
        int B = NodeNames.indexOf(nodeB);

        array.get(A).add(B);
        array.get(B).add(A);
    }

    public String NN(int i){
        return NodeNames.get(i);
    }

    public void display(){

        for(ArrayList<Integer> a: array ){

            System.out.print("Node: "+ NodeNames.get(array.indexOf(a)) +" is connected with: ");

            for(Integer in: a){

                System.out.print(NodeNames.get(in) + ", ");
            }
            System.out.println();
        }
    }


    public void BFS(){

        int currentsize = array.size(), maxsize = currentsize +1;

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

            ArrayList<Integer> tab = array.get(v);
            int n = tab.size();
            Iterator<Integer> iter = tab.iterator();


            while(iter.hasNext()){

                int var = iter.next();

                if( visited[var]  ){
                    continue;
                }

                System.out.print( NN(var) + ", " );
                queue.add(var);
                visited[var] = true;

            }

            System.out.println();

        }

    }


    boolean[] visited;

    public void DFS(){

        visited = new boolean[array.size()+1];

        for(int k = 0; k < array.size()+1; k++){
            visited[k] = false;
        }

        DFS_(0);

    }



    public void DFS_(int v){

        visited[v] = true;



        System.out.print( NN(v) + "\n --> ");

        ArrayList<Integer> tab = array.get(v);
        Iterator<Integer> iter = tab.iterator();


        while(iter.hasNext()){

            int var = iter.next();

            if( !visited[var]  ){

                DFS_(var);
            }

        }

    }


}
