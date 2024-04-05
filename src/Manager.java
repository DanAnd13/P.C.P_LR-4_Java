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
   public int MaxEating(int[] arr){
       int max = arr[0];
       int id = 0;
       for(int i = 0; i < arr.length; i ++) {
           if (max <= arr[i]) {
               max = arr[i];
               id = i;
           }
       }
       return id;
   }
}
