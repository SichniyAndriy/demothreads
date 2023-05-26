package pingpong;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ServicePingPong {
    private final int amount;
    private boolean flag;


    public ServicePingPong(int amount) {
        this.amount = amount;
        this.flag = true;
    }

    public int getAmount() {
        return amount;
    }

    public synchronized void printPing(final int i) {
        while(!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                error(e);
            }
        }
        System.out.printf("%3d Ping%n", i);
        flag = false;
        notifyAll();
    }

    public synchronized void printPong(final int i) {
        while(flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                error(e);
            }
        }
        System.out.printf("%3d Pong%n", i);
        flag = true;
        notifyAll();
    }

    private void error(Throwable e) {
        String notification =
                String.format("Thread %s interrupted: ", Thread.currentThread().getName());
        Logger.getGlobal().log(Level.WARNING, notification, e);
        Thread.currentThread().interrupt();
    }
}
