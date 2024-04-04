import java.util.concurrent.Semaphore;
public class Manager {
   Semaphore waiter;
   Semaphore[] forks = new Semaphore[5];

   public Manager(){
       waiter = new Semaphore(1);
       for(int i=0; i<forks.length;i++) {
           forks[i] = new Semaphore(1);
       }
   }
}
