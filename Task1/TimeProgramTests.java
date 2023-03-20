package Task1;
import java.util.concurrent.TimeUnit;

public class TimeProgramTests {
        public static void main(String[] args) {
            Thread timeOfWorkThread = new Thread(TimeProgramTests::run);
            Thread notificationThread = new Thread(TimeProgramTests::run2);

            timeOfWorkThread.start();
            notificationThread.start();}

    private static void run() {
        long programStart = System.currentTimeMillis();
        while (true) {
            long passedTime = System.currentTimeMillis() - programStart;
            System.out.println("Passed time: " + formatting(passedTime));
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
            private static void run2 () {
                while (true) {
                    try {
                        TimeUnit.SECONDS.sleep(5);
                        System.out.println("5 seconds have passed!");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            private static String formatting(long millis){
                long hours = TimeUnit.MILLISECONDS.toHours(millis);
                long minutes = TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(hours);
                long seconds = TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(minutes) - TimeUnit.HOURS.toSeconds(hours);
                return hours+" hours "+minutes+" minutes "+seconds+" seconds...";
            }
}
