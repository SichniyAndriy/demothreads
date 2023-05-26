package pingpong;

public class Main {
    public static void main(String[] args) {
        ServicePingPong servicePingPong = new ServicePingPong(20);
        Thread threadPing = new Thread(new Ping(servicePingPong), "PingThread");
        Thread threadPong = new Thread(new Pong(servicePingPong), "PongThread");

        threadPing.start();
        threadPong.start();
    }
}
