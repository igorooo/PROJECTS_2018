

public class HashMap {

    private Student[] array;
    private int CurrentSize;
    private int size;
    boolean method;  //  if method == true then method is next Line adress
    boolean[] tab;

    public HashMap(int size,boolean method){

        array = new Student[size];
        CurrentSize = 0;
        this.size = size;
        this.method = method;

    }

    public int size(){
        return size;
    }

    public boolean Method(){
        return method;
    }

    public void resize(int newsize){
        Student[] array = new Student[newsize];

        for(int i = 0; i < this.size; i++){
            array[i] = this.array[i];
        }
        this.array = array;
        this.size = newsize;
    }

    private int HashFunct(String nazwisko){
        int len = nazwisko.length();
        int hashCode = 0;

        for(int i = 0; i < len; i++){

            hashCode += ((int)(nazwisko.charAt(i))) ^ len;
        }
        hashCode %= size;

        return hashCode;
    }

    private int NextLineAdress(int index){

        int i=1;
        while(array[index] != null){
            index = (index + i++) % size;
        }

        return index;
    }



    private int NextSquareAdress(int index){

        int i=1,val;

        while(array[index] != null){
            val = (int) (Math.pow((-1), i-1) * Math.pow((i+1)/2,2)) % size;
            index += val;

            if(index < 0){
                index *= -1;
            }

            index = index % size;
            i++;

        }

        return index;
    }

    /**         key will be Student.id <---   **/

    public boolean put(String key,Student elem){

        if(CurrentSize >= size){
            System.out.println("Array Full");
            return false;
        }
        int index=0;

        if(method){
            index = NextLineAdress(HashFunct(key));
        }
        if(!method){
            index = NextSquareAdress(HashFunct(key));
        }

        array[index] = elem;
        CurrentSize++;
        return true;

    }

    public Student get(String key, Comp comp){

        int i,index,val;

        tab = new boolean[size];

        for(i=0;i<size;i++){
            tab[i]=false;
        }

        index = HashFunct(key);

        comp.restart();


        if(array[index].id.compareTo(key) == 0){
            comp.setFound(true);
            return array[index];
        }

        if(method){

            i=0;


            while(array[index].id.compareTo(key) != 0){

                if(check()){
                    comp.setFound(false);
                    return null;
                }

                tab[index] = true;
                index = (index + i++) % size;
                comp.next();
            }
            comp.setFound(true);
            return array[index];

        }

        index = HashFunct(key);

        if(!method){

            i=0;

            while(array[index].id.compareTo(key) != 0){


                if(check()){
                    comp.setFound(false);
                    return null;
                }

                tab[index] = true;
                val = (int) (Math.pow((-1), i-1) * Math.pow((i+1)/2,2));
                index += val;

                if(index < 0){
                    index *= -1;
                }

                index = index % size;
                comp.next();
                i++;
            }

        }

        comp.setFound(true);
        return array[index];

    }

    private boolean check(){
        for(int i=0;i<size;i++){
            if(tab[i]==false){
                return false;
            }
        }
        return true;
    }


    public boolean isEmpty(){
        return CurrentSize == 0;
    }

    public void dump(){
        for(int i = 0; i < size; i++){
            System.out.println(array[i]+"    -----> index: "+ i);
        }
    }












}
