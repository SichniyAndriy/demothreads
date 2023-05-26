package leftright;

public class Left implements Runnable {
    private final Walk walk;

    public Left(Walk walk) {
        this.walk = walk;
    }

    @Override
    public void run() {
        while(walk.decrementSteps() > 0) {
            walk.stepLeft();
        }
    }
}
