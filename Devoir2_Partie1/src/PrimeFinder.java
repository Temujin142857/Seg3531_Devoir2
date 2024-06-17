import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;

public class PrimeFinder extends Thread{

    ArrayList<Integer> primes;
    ArrayBlockingQueue<Integer> nums;

    public PrimeFinder(ArrayList<Integer> primes, ArrayBlockingQueue<Integer> nums) {
        this.primes=primes;
        this.nums=nums;
    }

    @Override
    public void run() {
        try {
            findPrimes();
        }catch(Exception ignored){
        }
    }

    private void findPrimes(){
        int toCheck;
        while (!(nums.peek() ==null)){
            toCheck=nums.poll();
            if(checkIfPrime(toCheck)){
                primes.add(toCheck);
            }
        }
    }

    private boolean checkIfPrime(int toCheck){
        //using an iterator to free up primes to be accessed by other threads while calulations are ongoing
        //I think that's how it works anyway, I'll look into it further later
        Iterator<Integer> iPrimes= primes.iterator();
        while(iPrimes.hasNext()){
            int p= iPrimes.next();
            if(p>Math.floor(Math.sqrt(toCheck)))return true;
            else if(toCheck%p==0)return false;
        }
        return true;
    }

}
