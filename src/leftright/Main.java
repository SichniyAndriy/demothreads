package leftright;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Walk walk = new Walk(20);
        Thread threadLeft = new Thread(new Left(walk), "LeftThread");
        Thread threadRight = new Thread(new Right(walk), "RightThread");

        threadLeft.start();
        threadRight.start();
        threadLeft.join();
        threadRight.join();

        System.out.println("\nNext walking:\n");

        walk = new Walk(20, false);
        Thread leftThread = new Thread(new Left(walk), "LeftThread");
        Thread rightThread = new Thread(new Right(walk), "RightThread");

        leftThread.start();
        rightThread.start();
        threadLeft.join();
        threadRight.join();
    }
}
