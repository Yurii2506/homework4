package fsdf;
import java.util.concurrent.TimeUnit;

public class TimeDisplayProgram {
    public static void main(String[] args) {

        Thread timeDisplayThread = new Thread(() -> {
            long startTime = System.currentTimeMillis();
            while (true) {
                long currentTime = System.currentTimeMillis() - startTime;
                long elapsedSeconds = TimeUnit.MILLISECONDS.toSeconds(currentTime);

                System.out.printf("Пройшло часу: %d секунд%n", elapsedSeconds);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        timeDisplayThread.start();

        Thread messageThread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(5000);
                    System.out.println("Минуло 5 секунд");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        messageThread.start();
    }
}
