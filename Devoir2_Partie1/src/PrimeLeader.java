import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

public class PrimeLeader extends Thread{
    int num=0;
    public PrimeLeader(int num) {
        this.num=num;
    }

    @Override
    public void run() {
        findPrimes(num);
    }


    private void findPrimes(int num){
        ArrayList<Integer> primes =new ArrayList<>();
        //add a few primes to limit concurrency issues, i.e. one thread looking at 6 before the thread looking at 3 finishes
        primes.add(2);
        primes.add(3);
        primes.add(5);
        primes.add(7);
        primes.add(11);
        primes.add(13);
        primes.add(17);
        primes.add(19);

        ArrayBlockingQueue<Integer> nums=new ArrayBlockingQueue<>(num);
        for (int i = 0; i < num; i++) {
            if(i>=20) {
                nums.add(i);
            }
        }

        //use 16 threads since that's how many cores my laptop has
        PrimeFinder[] finders=new PrimeFinder[16];
        for (int i = 0; i < 16; i++) {
            finders[i]=new PrimeFinder(primes, nums);
            finders[i].start();
        }
        try {
            for (int i = 0; i < 16; i++) {
                finders[i].join();
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("something went wrong joining");
        }

        System.out.println("finished");
        for (int p:primes) {
            System.out.print(p+",");
        }

    }
}
