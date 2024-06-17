import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

public class Main {

    public static void main(String[] args) {
        int num=0;
        System.out.println("Give me an integer");
        Scanner in = new Scanner(System.in);
        num = Integer.parseInt(in.nextLine());
        PrimeLeader mainThread=new PrimeLeader(num);
        mainThread.start();
    }



}