/**
 * Created by PC on 06.03.2018.
 */
public class ITab implements Iteratorr {

    private Student[] tab;

    int i=0,iter = 0, l=0;


    public ITab(Student[] tab1,int len){
        tab = new Student[len];
        tab = tab1;
        l = tab.length;
    }

    public boolean GoodGrade(){

        if(tab[iter].grade >= 3){
            return true;
        }

        else{
            return false;
        }
    }

    @Override
    public void first() {
        iter = 0;
    }

    @Override
    public void next() {
        iter++;
    }

    @Override
    public boolean isDone() {
        return  iter >= (l-1);
    }

    @Override
    public Student current() {
        return  tab[iter];
    }
}
