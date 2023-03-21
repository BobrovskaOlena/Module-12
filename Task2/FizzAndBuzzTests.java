package Task2;

import java.util.ArrayList;
import java.util.List;

public class FizzAndBuzzTests {
    public static void main(String[] args) {
        FizzAndBuzz A = new FizzAndBuzz((n) -> {
            if (n % 3 == 0) {
                System.out.println("Fizz");
            }
        });
        FizzAndBuzz B = new FizzAndBuzz((n) -> {
            if (n % 5 == 0) {
                System.out.println("Buzz");
            }
        });
        FizzAndBuzz C = new FizzAndBuzz((n) -> {
            if (n % 15 == 0) {
                System.out.println("FizzBuzz");
            }
        });
        FizzAndBuzz D = new FizzAndBuzz((n) -> {
            if ((n % 3 != 0) && (n % 5 != 0)) {
                System.out.println(n);
            }
        });
        List<FizzAndBuzz> threads = new ArrayList<>();
        threads.add(A);
        threads.add(B);
        threads.add(C);
        threads.add(D);
        for (FizzAndBuzz thread : threads) {
            thread.start();
        }
        for (int i = 1; i <= 30; i++) {
            for (FizzAndBuzz thread : threads) {
                thread.process(i);
            }
        while (true) {
            int count = 0;
            for (FizzAndBuzz thread : threads) {
                if (thread.isProcessed()) {
                    count++;
                }
            }
            if (count == threads.size()) {
                break;
            }
        }

        }
    }
}
