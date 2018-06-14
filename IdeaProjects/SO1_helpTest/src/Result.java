public class Result {

    int result;
    int AMOUNT;


    public Result(int AMOUNT){
        result = 0;
        this.AMOUNT = AMOUNT;
    }

    public void ADD(int t){
        result += t;
    }

    @Override
    public String toString() {
        return Double.toString((result*1.0)/(AMOUNT*1.0));
    }
}
