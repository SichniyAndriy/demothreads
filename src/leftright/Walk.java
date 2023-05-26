package leftright;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Walk {
    private int steps;
    private boolean isLeft;

    private static final int DELAY = 250;

    public Walk(final int steps) {
        this.steps = steps;
        this.isLeft = true;
    }

    public Walk(final int steps, final boolean flag) {
        this.steps = steps;
        this.isLeft = flag;
    }

    public int decrementSteps() {
        return steps--;
    }

    public synchronized void stepLeft() {
        while(!isLeft) {
            try {
                wait();
            } catch (InterruptedException e) {
                error(e);
            }
        }
        makeDelay();
        System.out.println("Left");
        isLeft = false;
        notifyAll();
    }

    public synchronized void stepRight() {
        while (isLeft) {
            try {
                wait();
            } catch (InterruptedException e) {
                error(e);
            }
        }
        makeDelay();
        System.out.println("Right");
        isLeft = true;
        notifyAll();
    }

    private void makeDelay() {
        try {
            Thread.sleep(DELAY);
        } catch (InterruptedException e) {
           error(e);
        }
    }
    private void error(Throwable e) {
        String notification =
                String.format("Thread %s interrupted: ", Thread.currentThread().getName());
        Logger.getGlobal().log(Level.WARNING, notification, e);
        Thread.currentThread().interrupt();
    }
}
