package leftright;

public class Right implements Runnable {
    private final Walk walk;

    public Right(Walk walk) {
        this.walk = walk;
    }

    @Override
    public void run() {
        while (walk.decrementSteps() > 0){
            walk.stepRight();
        }
    }
}
