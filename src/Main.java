
public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        Phylosophers[] phylosophers = new Phylosophers[5];
        for (int i = 0; i < phylosophers.length; i++) {
            phylosophers[i] = new Phylosophers(i, manager);
        }
    }
}