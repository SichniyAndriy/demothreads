package leftright;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final Walk walk = new Walk(20);
        ThreadFactory threadFactory = Executors.defaultThreadFactory();

        Thread threadLeft = threadFactory.newThread(() -> {
            while (walk.decrementSteps() > 0) {
                walk.stepLeft();
            }
        });
        threadLeft.setName("LeftThread");

        Thread threadRight = threadFactory.newThread(() -> {
            while (walk.decrementSteps() > 0) {
                walk.stepRight();
            }
        });
        threadRight.setName("RightThread");

        threadLeft.start();
        threadRight.start();
        threadLeft.join();
        threadRight.join();
    }
}
