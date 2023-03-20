package Task1;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ProgramTime {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(
                ()-> System.out.println(System.currentTimeMillis()),
                0,
                1,
                TimeUnit.SECONDS
        );
        new Thread(() -> System.out.println("Program started")
        ).start();
        Thread.sleep(5000);
        System.out.println("Five seconds have passed!");
        /*try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
    }
}
