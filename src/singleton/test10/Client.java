package singleton.test10;


/**
 * In order to overcome the challenges (the use of `volatile` necessarily)
 * of multi-threaded lazy loading singleton pattern,
 * `private inner static class` can be used.
 * https://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-examples
 */
public class Client extends Thread {

    public static void main(String[] args) {
        for(int i = 0; i < 1000; i++) {
            new Client().run();
        }
    }

    @Override
    public void run() {
        BillPughSingleton ls = BillPughSingleton.getInstance();
        ls.printName();
    }
}
