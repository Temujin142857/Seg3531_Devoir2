import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public volatile ArrayList<Integer> sequence=new ArrayList<>();

    public static void main(String[] args) {
        int num=0;
        System.out.println("Give me an integer");
        Scanner in = new Scanner(System.in);
        num = Integer.parseInt(in.nextLine());
        Main main=new Main();
        FibbonacciFinder finder=new FibbonacciFinder(num, main.sequence);
        finder.start();
        try {
            finder.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (int f:main.sequence) {
            System.out.print(f+",");
        }


    }


}