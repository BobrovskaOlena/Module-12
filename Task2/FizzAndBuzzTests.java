package Task2;

import java.util.ArrayList;
import java.util.List;

public class FizzAndBuzzTests {
    public static void main(String[] args) {
        FizzAndBuzz fizz = new FizzAndBuzz((n) -> {
            if (n % 3 == 0) {
                System.out.println("Fizz");
            }
        });
        FizzAndBuzz buzz = new FizzAndBuzz((n) -> {
            if (n % 5 == 0) {
                System.out.println("Buzz");
            }
        });
        FizzAndBuzz fizzAndBuzz = new FizzAndBuzz((n) -> {
            if (n % 15 == 0) {
                System.out.println("FizzBuzz");
            }
        });
        FizzAndBuzz num = new FizzAndBuzz((n) -> {
            if ((n % 3 != 0) && (n % 5 != 0)) {
                System.out.println(n);
            }
        });
        List<FizzAndBuzz> threads = new ArrayList<>();
        threads.add(fizzAndBuzz);
        threads.add(fizz);
        threads.add(buzz);
        threads.add(num);
        for (FizzAndBuzz thread : threads) {
            thread.start();
        }
        for (int i = 1; i <= 30; i++) {
            for (FizzAndBuzz thread : threads) {
                thread.process(i);
            }
        }
        int count = 0;
        while (true) {
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
