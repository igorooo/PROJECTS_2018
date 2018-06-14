import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class test {

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);



        Stos<String> stos = new Stos<String>(15);
        String a;

        while( scan.hasNextLine() ){

            a = scan.next();
            stos.push(a);

            if(a.contains("break")){
                break;
            }

        }

        while(!stos.isEmpty()){
            System.out.println(stos.pop());
        }


        // ------------------------------------------------------

        String line;
        FileReader fr = new FileReader("tt.txt");
        Scanner in = new Scanner(fr);


        Stos<Integer> pf = new Stos<Integer>(20);

        String c;
        int buf;



        while(in.hasNext()){
            c = in.next();

            if(c.compareTo("+") == 0){
                buf = pf.pop() + pf.pop();
                pf.push(buf);
                continue;
            }

            if(c.compareTo("*") == 0){
                buf = pf.pop() * pf.pop();
                pf.push(buf);
                continue;
            }

            else{
                pf.push(Integer.parseInt(c));
            }

        }

        System.out.println("Wynik dzialania: "+pf.pop());




    }


}
