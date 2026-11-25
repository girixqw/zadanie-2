import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();

        int[] arr = new int[1000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(10001);
        }

        int minDiv37 = Integer.MAX_VALUE;
        int maxDiv73 = Integer.MIN_VALUE;

        for (int value : arr) {
            if (value % 37 == 0 && value < minDiv37) {
                minDiv37 = value;
            }
            if (value % 73 == 0 && value > maxDiv73) {
                maxDiv73 = value;
            }
        }

        int lo = Math.min(minDiv37, maxDiv73);
        int hi = Math.max(minDiv37, maxDiv73);

        int pairs = 0;
        int bestSum = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length - 1; i++) {
            int x = arr[i];
            int y = arr[i + 1];

            boolean xInside = x > lo && x < hi;
            boolean yInside = y > lo && y < hi;

            if (xInside != yInside) {
                pairs++;
                int s = x + y;
                if (s < bestSum) {
                    bestSum = s;
                }
            }
        }

        System.out.println(pairs + " " + bestSum);

        sc.close();
    }
}