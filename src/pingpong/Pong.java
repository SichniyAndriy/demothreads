package pingpong;

public class Pong implements Runnable {
    private final ServicePingPong servicePingPong;

    public Pong(ServicePingPong servicePingPong) {
        this.servicePingPong = servicePingPong;
    }

    @Override
    public void run() {
        int i = 0;
        while (i++ < servicePingPong.getAmount()) {
            servicePingPong.printPong(i);
        }
    }
}
