

public class Rot {

    IQueue queue;

    private int avarageTime;
    private int timeQuant;

    public Rot(IQueue queue,int timeQuant){

        this.queue = queue;
        this.timeQuant = timeQuant;

        avarageTime = 0;

        int i,done=0;

        for(i = 0; done < queue.size() ; i++){

            if( i == queue.size()-1){
                i = 0;
            }

            if(timeQuant > queue.getProces(i).getDelay()){

                if(!queue.getProces(i).isDone()){

                    if(timeQuant > queue.getProces(i).getFazaProc()){

                        avarageTime += queue.getProces(i).getFazaProc();
                        queue.getProces(i).setTimeDone(timeQuant);
                        done++;
                    }

                    else{
                        avarageTime +=timeQuant;
                        queue.getProces(i).setTimeDone(timeQuant);
                    }

                }

                else{
                    done++;
                }


            }

            else{

                if(!queue.getProces(i).isDone()){

                    if(timeQuant > queue.getProces(i).getFazaProc()){

                        avarageTime += queue.getProces(i).getFazaProc() + queue.getProces(i).getDelay();
                        queue.getProces(i).setTimeDone(timeQuant);
                        done++;
                    }

                    else{
                        avarageTime +=timeQuant + queue.getProces(i).getDelay();
                        queue.getProces(i).setTimeDone(timeQuant);
                    }
                }

                else{
                    done++;
                }

            }

        }

        avarageTime /= queue.size()-1;

    }

    public int getAvarageTime(){
        return avarageTime;
    }

}
