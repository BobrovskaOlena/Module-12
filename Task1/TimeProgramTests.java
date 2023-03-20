package Task1;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.*;

public class TimeProgramTests {
        public static void main(String[] args) {
            Thread timeOfWorkThread = new Thread(TimeProgramTests::run);

            // Створення потоку для виведення повідомлення про минулих 5 секунд
            Thread messageThread = new Thread(() -> {
                while (true) {
                    try {
                        TimeUnit.SECONDS.sleep(5);
                        System.out.println("Минуло 5 секунд");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            // Запуск потоків
            timeOfWorkThread.start();
            messageThread.start();
        }

        // Функція для форматування часу у години, хвилини, секунди
        private static String formatTime(long millis) {
            long hours = TimeUnit.MILLISECONDS.toHours(millis);
            long minutes = TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(hours);
            long seconds = TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(minutes) - TimeUnit.HOURS.toSeconds(hours);
            return String.format("%02d:%02d:%02d", hours, minutes, seconds);
        }

    private static void run() {
        long programStart = System.currentTimeMillis();
        while (true) {
            long passedTime = System.currentTimeMillis() - programStart;
            System.out.println("Passed time: " + formatTime(passedTime));
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
