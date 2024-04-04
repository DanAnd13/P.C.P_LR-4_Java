import java.util.concurrent.Delayed;

public class Phylosophers implements Runnable {
    private final int id;
    private final Manager manager;
    public Phylosophers(int id, Manager manager) {
        this.id = id;
        this.manager = manager;
        new Thread(this).start();
    }
    @Override
    public void run() {
        int leftFork = id;
        int rightFork = (id+1) % manager.forks.length;

        try {
            for (int i = 0; i < 2; i++) {
                System.out.println("Philosopher " + (id+1) + " thinking " + (i+1) + " time");

                manager.waiter.acquire();
                manager.forks[leftFork].acquire();

                System.out.println("Philosopher " + (id + 1) + " took left fork");

                manager.forks[rightFork].acquire();

                System.out.println("Philosopher " + (id + 1) + " took right fork");
                System.out.println("Philosopher " + (id + 1) + " eating " + (i + 1) + " time");

                manager.waiter.release();
                manager.forks[rightFork].release();

                System.out.println("Philosopher " + (id + 1) + " put right fork");

                manager.forks[leftFork].release();

                System.out.println("Philosopher " + (id + 1) + " put left fork");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
