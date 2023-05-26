package pingpong;

public class Ping implements Runnable {
    private final ServicePingPong servicePingPong;

    public Ping(ServicePingPong servicePingPong) {
        this.servicePingPong = servicePingPong;
    }

    @Override
    public void run() {
        int i = 0;
        while (i++ < servicePingPong.getAmount()) {
            servicePingPong.printPing(i);
        }
    }
}
