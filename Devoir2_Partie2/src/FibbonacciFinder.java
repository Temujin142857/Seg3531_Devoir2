import java.util.ArrayList;

public class FibbonacciFinder extends Thread{

    private int num=0;
    public volatile ArrayList<Integer> sequence;

    FibbonacciFinder(int num, ArrayList<Integer> sequence){
        this.num=num;
        this.sequence=sequence;
    }

    @Override
    public void run() {
        sequence.add(1);
        sequence.add(1);
        for (int i = 2; i < num; i++) {
            sequence.add(sequence.get(i-1)+sequence.get(i-2));
        }
    }
}
